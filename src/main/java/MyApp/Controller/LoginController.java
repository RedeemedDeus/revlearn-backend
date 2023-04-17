package MyApp.Controller;

import MyApp.Exceptions.UnauthorizedUserException;
import MyApp.Model.Login;
import MyApp.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
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
    public Login register(@RequestBody Login login) {
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
    public Object login(@RequestBody Login login) throws UnauthorizedUserException{
        return loginService.login(login);
    }

    @ExceptionHandler(UnauthorizedUserException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "invalid login credentials, please try again!")
    public void handleUnauthorized(){
    }
}
