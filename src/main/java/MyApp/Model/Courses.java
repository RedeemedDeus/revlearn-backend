package MyApp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Courses {
}

/*In satisfying user stories for students to be able to register for a class, interact within a class, get their grades for a class
there needed to be a model for a course.
This model leverages the use of Spring ORM with JpaRepository for the creation of the table and handling of they SQL calls.
It also leverages Lombok for creation of all setters, getters, and constructors.

Relationships:
1-to-many -> student < courses
1-to-many -> educators < courses
1-to-1 -> course to forum */

