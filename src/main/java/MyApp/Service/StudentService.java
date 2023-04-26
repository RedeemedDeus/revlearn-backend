package MyApp.Service;

import MyApp.Model.Courses;
import MyApp.Model.Login;
import MyApp.Model.Student;
import MyApp.Repository.CourseRepo;
import MyApp.Repository.LoginRepository;
import MyApp.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    StudentRepository studentRepository;
    LoginRepository loginRepository;
    CourseRepo courseRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, LoginRepository loginRepository, CourseRepo courseRepository) {
        this.studentRepository = studentRepository;
        this.loginRepository = loginRepository;
        this.courseRepository = courseRepository;
    }

    /**
     * Register a new student that is attached to a login
     * @param student
     * @param id
     * @return
     */
    public Student registerStudent(Student student, long id) {
        Login login = loginRepository.findById(id).get();
        login.setStudent(student);
        student.setLogin(login);
        return studentRepository.save(student);
    }

    /**
     * get all students currently enrolled
     * @return
     */
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }


    /**
     * Edits a students details
     * @param id
     * @param student
     * @return
     */
    public Student editStudent(long id, Student student) {
        if(studentRepository.existsById(id)){
            Student studentOnDb = studentRepository.findById(id).get();
            student.setId(id);
            student.setLogin(studentOnDb.getLogin());
            studentOnDb = student;
            return studentRepository.save(studentOnDb);
        }
        return null;
    }

    /**
     * Has a student take a course, cost is added to their balance, course is added to their courses
     * @param sid
     * @param cid
     * @return
     */
    public Courses takeCourse(long sid, long cid) {
        Student student = studentRepository.findById(sid).get();
        Courses course = courseRepository.findById(cid).get();
        student.getMyCourses().add(course);
        student.setBalance(student.getBalance() + course.getCost());
        studentRepository.save(student);
        return course;
    }

    /**
     * Gets the courses a particular student is enrolled in using student id
     * @param id
     * @return
     */
    public List<Courses> getCoursesByStudent(long id) {
        Student student = studentRepository.findById(id).get();
        return student.getMyCourses();
    }

    /**
     * drops a course from a students courses
     * @param sid
     * @param cid
     * @return
     */
    public boolean dropCourse(long sid, long cid) {
        Student student = studentRepository.findById(sid).get();
        Courses course = courseRepository.findById(cid).get();

        if(student.getMyCourses().contains(course)){
            student.getMyCourses().remove(course);
            student.setBalance(student.getBalance() - course.getCost());
            studentRepository.save(student);
            return true;
        }
        else{
            return false;
        }

    }

    /**
     * pays off a students balance if the transaction succeeds
     * @param id
     * @return
     */
    public Student payBalance(long id) {
        Student student = studentRepository.findById(id).get();
        student.setBalance(0.0);
        return studentRepository.save(student);
    }
}
