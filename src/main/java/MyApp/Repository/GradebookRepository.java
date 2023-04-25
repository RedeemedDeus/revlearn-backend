package MyApp.Repository;

import MyApp.Model.Gradebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GradebookRepository extends JpaRepository<Gradebook, Long> {

    List<Gradebook> findAllByStudentIdOrderByCourseId(int studentId);

}
