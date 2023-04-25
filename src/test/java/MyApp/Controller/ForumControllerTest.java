package MyApp.Controller;

import MyApp.Model.Forum;
import MyApp.Service.ForumService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ForumControllerTest {

    @Mock
    ForumService forumService;

    @InjectMocks
    ForumController forumController;

    private MockMvc mockMvc;

    @Test
    void addForumTest() throws Exception {
        Forum forum = new Forum();
        forum.setCourseId(1);
        forum.setUserId(2);
        forum.setTextBody("Test");
        forum.setCreatedAt(Timestamp.from(Instant.now()));

        when(forumService.addForum(forum)).thenReturn(forum);

        mockMvc = MockMvcBuilders.standaloneSetup(forumController).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/forum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"courseId\": 1, \"userId\": 2, \"textBody\": \"Test\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.courseId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.textBody").value("Test"));
    }

    @Test
    void getAllForumsByCourseIdTest() throws Exception {
        List<Forum> forums = new ArrayList<>();
        forums.add(new Forum(1, 1, 1, "Test1", Timestamp.from(Instant.now())));
        forums.add(new Forum(2, 1, 2, "Test2", Timestamp.from(Instant.now())));

        when(forumService.getAllForumsByCourseId(1)).thenReturn(forums);

        mockMvc = MockMvcBuilders.standaloneSetup(forumController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/forums/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].courseId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].userId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].textBody").value("Test1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].courseId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].userId").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].textBody").value("Test2"));
    }
}