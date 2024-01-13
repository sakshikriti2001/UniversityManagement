package UniversityManagementSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Student {
    @Id
    private Long id;
    private String fullName;
    private String program;

    // Other student-related attributes can be added

    @OneToMany(mappedBy = "student")
    private List<Appointment> appointments;
}