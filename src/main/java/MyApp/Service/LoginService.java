package MyApp.Service;

import MyApp.Exceptions.DuplicateUserException;
import MyApp.Exceptions.UnauthorizedUserException;
import MyApp.Model.Login;
import MyApp.Model.Student;
import MyApp.Repository.LoginRepository;
import MyApp.Repository.StudentRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Random;

@Service
public class LoginService {
    LoginRepository loginRepository;
    StudentRepository studentRepository;

    EmailSenderService emailSenderService;

    PasswordEncoder passwordEncoder;

    @Autowired
    public LoginService(LoginRepository loginRepository, StudentRepository studentRepository, EmailSenderService emailSenderService) {
        this.loginRepository = loginRepository;
        this.studentRepository = studentRepository;
        this.emailSenderService = emailSenderService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }


    /**
     * register a new user
     * @param login
     * @return
     */
    public Login register(Login login) throws DuplicateUserException, MessagingException, jakarta.mail.MessagingException, UnsupportedEncodingException {

        if(loginRepository.findByEmail(login.getEmail()) != null){
            throw new DuplicateUserException();
        }

        if(login.getUser_type().equals("student")){
            Student student = new Student();
            student = studentRepository.save(student);
            login.setStudent(student);

            emailSenderService.sendVerificationEmail(login);


            return loginRepository.save(login);
        }
        else if(login.getUser_type().equals("educator")){

        }
        else if(login.getUser_type().equals("admin")){

        }

        return loginRepository.save(login);
    }

    /**
     * Get all login credentials
     * @return all login credentials
     */
    public List<Login> getAllLogin() {
        return loginRepository.findAll();
    }

    /**
     * posts a new login and returns the user account if successful,
     * @param login
     * @return user account (Student,Educator, or Admin)
     * @throws UnauthorizedUserException
     */
    public Object login(Login login) throws UnauthorizedUserException {
        Login loginOnDB = loginRepository.findByEmail(login.getEmail());

        if(loginOnDB == null){
            throw new UnauthorizedUserException();
        }

        if(BCrypt.checkpw(login.getPassword(),loginOnDB.getPassword())) {
            if(loginOnDB.getUser_type().equals("student")) return loginOnDB.getStudent();
        }
        else {
            throw new UnauthorizedUserException();
        }

        return null;
    }


    public Login editLogin(Login login, long id) {
        if(loginRepository.existsById(id) && login.getUser_type().equals("student")){
            Login loginOnDb = loginRepository.findById(id).get();
            login.setId(id);
            login.setStudent(loginOnDb.getStudent());

            //HASH THE NEW USER PASSWORD
            String hashed = BCrypt.hashpw(login.getPassword(), BCrypt.gensalt(12));
            login.setPassword(hashed);

            loginOnDb = login;
            return loginRepository.save(loginOnDb);
        }
        else if(loginRepository.existsById(id) && login.getUser_type().equals("educator")){

        }
        else if(loginRepository.existsById(id) && login.getUser_type().equals("admin")){

        }

        return null;
    }


    public void passwordReset(Login login) throws MessagingException, jakarta.mail.MessagingException, UnsupportedEncodingException {
        Login accountExists = loginRepository.findByEmail(login.getEmail());

        if(accountExists == null){
            throw new UsernameNotFoundException("User with " + login.getEmail()+ " not found");
        }
        Random random = new Random();
        String randomCode = String.valueOf(random.nextInt(9999999));

        String hashed = BCrypt.hashpw(randomCode, BCrypt.gensalt(12));

        accountExists.setPassword(hashed);

        emailSenderService.sendPasswordReset(accountExists,randomCode);
        loginRepository.save(accountExists);
    }

}
