package MyApp.Controller;

import MyApp.Exceptions.DuplicateUserException;
import MyApp.Exceptions.UnauthorizedUserException;
import MyApp.Model.Login;
import MyApp.Service.LoginService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
public class LoginController {
    LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 1. As a user I should be able to register a new account
     * POST localhost:9000/register
     */
    @PostMapping("register")
    public Login register(@RequestBody Login login) throws DuplicateUserException, MessagingException, jakarta.mail.MessagingException, UnsupportedEncodingException {
        String hashed = BCrypt.hashpw(login.getPassword(), BCrypt.gensalt(12));
        login.setPassword(hashed);

        return loginService.register(login);
    }

    /**
     * 1.1 As an admin I should be able all login credentials
     * GET localhost:9000/login
     */
    @GetMapping("login")
    public List<Login> getAllLogin() {
        return loginService.getAllLogin();
    }


    /**
     * 2. As a user I should be able to login in to my account
     * POST localhost:9000/login
     */
    @PostMapping("login")
    public Object login(@RequestBody Login login) throws UnauthorizedUserException {
        return loginService.login(login);
    }

    @ExceptionHandler(UnauthorizedUserException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "invalid login credentials, please try again!")
    public void handleUnauthorized(){
    }

    @ExceptionHandler(DuplicateUserException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "This user is already registered, please try again!")
    public void handleDuplicate(){
    }

    /**
     * 3. As a user I should be able to edit my profile and change things there
     * PATCH localhost:9000/login/{id}
     */
    @PatchMapping("login/{id}")
    public Login editLogin(@RequestBody Login login, @PathVariable long id){
        return loginService.editLogin(login,id);
    }


    @PostMapping("password")
    public ResponseEntity<String> passwordReset(@RequestBody Login login) throws MessagingException, UnsupportedEncodingException {

        try {
            loginService.passwordReset(login);
        } catch (jakarta.mail.MessagingException | MessagingException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
