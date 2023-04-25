package MyApp.Controller;

import MyApp.Model.Gradebook;
import MyApp.Service.GradebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class GradebookController {

    GradebookService gradebookService;

    @Autowired
    public GradebookController(GradebookService gradebookService) {
        this.gradebookService = gradebookService;
    }
    /**
     *@param gradebook The Gradebook object to be added.
     *@return The Gradebook object that was added.
     */
    @PostMapping("gradebook")
    public Gradebook addGradebook(@RequestBody Gradebook gradebook) {
        return gradebookService.addGradebook(gradebook);
    }
     /**
     *Retrieves a list of all gradebook entries for a given student.
     *@param studentid The ID of the student.
     *@return A list of Gradebook objects for the specified student.
     */
    @GetMapping("gradebooks/{studentid}")
    public List<Gradebook> getAllGradebooksByCourseId(@PathVariable int studentid) {
        return gradebookService.getAllGradebooksByStudentId(studentid);
    }
     /**
     *Updates an existing gradebook entry in the system by full object.
     *@param gradebook The Gradebook object to be updated in the system.
     */
    @PatchMapping("gradebook")
    public void updateGradebook(@RequestBody Gradebook gradebook) {
        gradebookService.updateGradebook(gradebook);
    }
}
