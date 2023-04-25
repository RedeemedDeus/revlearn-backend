package MyApp.Controller;

import MyApp.Model.Gradebook;
import MyApp.Service.GradebookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class GradebookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private GradebookService gradebookService;

    private GradebookController gradebookController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gradebookController = new GradebookController(gradebookService);
        mockMvc = MockMvcBuilders.standaloneSetup(gradebookController).build();
    }

    @Test
    void addGradebookTest() throws Exception {
        Gradebook gradebook = new Gradebook(1, 1, 1, 80);
        when(gradebookService.addGradebook(any(Gradebook.class))).thenReturn(gradebook);

        mockMvc.perform(MockMvcRequestBuilders.post("/gradebook")
                        .content("{ \"studentId\": 1, \"quizId\": 1, \"grades\": 80 }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.gradeId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quizId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.grades").value(80));
    }


    @Test
    void getAllGradebooksByCourseIdTest() throws Exception {
        List<Gradebook> gradebooks = new ArrayList<>();
        gradebooks.add(new Gradebook(1, 1, 1, 80));
        gradebooks.add(new Gradebook(2, 1, 2, 90));
        when(gradebookService.getAllGradebooksByStudentId(1)).thenReturn(gradebooks);

        mockMvc.perform(MockMvcRequestBuilders.get("/gradebooks/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].gradeId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].studentId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].quizId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].grades").value(80))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].gradeId").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].studentId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].quizId").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].grades").value(90));
    }

    @Test
    void testUpdateGradebook() throws Exception {
        Gradebook gradebook = new Gradebook(1, 1, 1, 90);
        when(gradebookService.addGradebook(any(Gradebook.class))).thenReturn(gradebook);
        when(gradebookService.getAllGradebooksByStudentId(1)).thenReturn(List.of(gradebook));
        mockMvc.perform(MockMvcRequestBuilders.post("/gradebook")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(gradebook)))
                .andExpect(status().isOk());
        gradebook.setGrades(85);
        mockMvc.perform(MockMvcRequestBuilders.patch("/gradebook")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(gradebook)))
                .andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/gradebooks/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].grades").value(85));
    }

    @Test
    void testGetAllGradebooksByStudentId() throws Exception {
        Gradebook gradebook1 = new Gradebook(1, 1, 1, 90);
        Gradebook gradebook2 = new Gradebook(2, 1, 2, 80);
        Gradebook gradebook3 = new Gradebook(3, 2, 1, 70);
        List<Gradebook> gradebooks = Arrays.asList(gradebook1, gradebook2);
        when(gradebookService.getAllGradebooksByStudentId(1)).thenReturn(gradebooks);
        mockMvc.perform(MockMvcRequestBuilders.get("/gradebooks/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].studentId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].studentId").value(1));
    }
}


