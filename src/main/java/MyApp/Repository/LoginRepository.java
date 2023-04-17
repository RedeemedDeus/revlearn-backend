package MyApp.Repository;

import MyApp.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface LoginRepository extends JpaRepository<Login,Long> {
    Login findByEmail(String email);
}
