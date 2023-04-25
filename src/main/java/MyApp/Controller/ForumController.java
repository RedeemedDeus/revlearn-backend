package MyApp.Controller;

import MyApp.Model.Forum;
import MyApp.Service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@CrossOrigin("*")
@RestController
public class ForumController {

    ForumService forumService;

    @Autowired
    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    /**

     * @param forum the forum object to be added
     * @return the newly added forum post
     */
    @PostMapping("forum")
    public Forum addForum(@RequestBody Forum forum) {
        forum.setCreatedAt(Timestamp.from(Instant.now()));
        return forumService.addForum(forum);
    }

    /**
     * @param course_id the ID of the course to retrieve forum posts for
     * @return a list of all forum posts for the specified course ID
     */
    @GetMapping("forums/{course_id}")
    public List<Forum> getAllForumsByCourseId(@PathVariable int course_id) {
        int temp = 1;
        return forumService.getAllForumsByCourseId(temp);
    }
}
