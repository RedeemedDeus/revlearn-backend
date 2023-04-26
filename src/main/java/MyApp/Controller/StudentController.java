package MyApp.Controller;

import MyApp.Model.Courses;
import MyApp.Model.Student;
import MyApp.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
public class StudentController {
    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * 1. A user should be able to register a new student
     * POST localhost:9000/student
     */
    @PostMapping("student/{id}")
    public Student registerStudent(@PathVariable long id, @RequestBody Student student) {
        return studentService.registerStudent(student,id);
    }

    /**
     * 1.1 A user should be able to see all students
     * GET localhost:9000/student
     */
    @GetMapping("student")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    /**
     * 2. A user should be able to change their personal details
     * PATCH localhost:9000/student/{id}
     */
    @PatchMapping("student/{id}")
    public Student editStudent(@PathVariable long id, @RequestBody Student student){
        return studentService.editStudent(id,student);
    }

    /**
     * 3. A student should be able to enroll in a course
     * POST localhost:9000/student/{sid}/course/{cid}
     */
    @PostMapping("student/{sid}/course/{cid}")
    public Courses takeCourse(@PathVariable long sid, @PathVariable long cid) {
        return studentService.takeCourse(sid,cid);
    }

    /**
     * 4. A student should be able to see its courses
     * GET localhost:9000/student/{id}/courses
     */
    @GetMapping("student/{id}/courses")
    public List<Courses> getCoursesByStudent(@PathVariable long id){
        return studentService.getCoursesByStudent(id);
    }

    /**
     * 5. A student should be able to drop a course if they want
     * GET localhost:9000/student/{id}/course/{id}/drop
     */
    @DeleteMapping("student/{sid}/course/{cid}")
    public boolean dropCourse(@PathVariable long sid, @PathVariable long cid) {
        return studentService.dropCourse(sid,cid);
    }

    /**
     * 6. A student can pay off their balance
     * PATCH localhost:9000/student/{id}/pay
     */
    @PatchMapping("student/{id}/pay")
    public Student payBalance(@PathVariable long id) {
        return studentService.payBalance(id);
    }

}
