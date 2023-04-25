package MyApp.Service;

import MyApp.Model.Forum;
import MyApp.Repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ForumService {
    ForumRepository forumRepository;
    @Autowired
    public ForumService(ForumRepository forumRepository){
        this.forumRepository = forumRepository;
    }

    public Forum addForum(Forum forum) {
        return forumRepository.save(forum);
    }

    public List<Forum> getAllForumsByCourseId(int courseId) {
        return forumRepository.findAllByCourseId(courseId);
    }
}
