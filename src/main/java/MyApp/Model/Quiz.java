package MyApp.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long quizId;
    @Column
    public Long courseId;
    @Column
    public String quizName;
    @Column
    public String question;
    @Column
    public String answer1;
    @Column
    public String answer2;
    @Column
    public String answer3;
    @Column
    public String answer4;
    @Column
    public String answer;
}
