package MyApp.Service;

import MyApp.Exceptions.UnauthorizedUserException;
import MyApp.Model.Login;
import MyApp.Repository.LoginRepository;
import MyApp.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    LoginRepository loginRepository;
    StudentRepository studentRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository, StudentRepository studentRepository) {
        this.loginRepository = loginRepository;
        this.studentRepository = studentRepository;
    }

    /**
     * register a new user
     * @param login
     * @return
     */
    public Login register(Login login) {
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

        if(loginOnDB.getPassword().equals(login.getPassword())) {
            if(loginOnDB.getUser_type().equals("Student")) return loginOnDB.getStudent();
        }
        else {
            throw new UnauthorizedUserException();
        }

        return null;
    }



}
