package MyApp.Service;

import MyApp.Model.Gradebook;
import MyApp.Repository.GradebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GradebookService {
    GradebookRepository gradebookRepository;
    @Autowired
    public GradebookService(GradebookRepository gradebookRepository){
        this.gradebookRepository = gradebookRepository;
    }
    public Gradebook addGradebook(Gradebook gradebook) {
        return gradebookRepository.save(gradebook);
    }

    public List<Gradebook> getAllGradebooksByStudentId(int courseId) {
        return gradebookRepository.findAllByStudentIdOrderByQuizName(courseId);
    }

    public void updateGradebook(Gradebook gradebook) {
        gradebookRepository.save(gradebook);
    }
}
