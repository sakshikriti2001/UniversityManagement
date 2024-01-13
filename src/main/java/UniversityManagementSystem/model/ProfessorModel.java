package UniversityManagementSystem.model;

import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
@Setter
@Getter
public class Professor {
    @Id
    private Long id;
    private String fullName;
    private String department;

    // Other professor-related attributes can be added

    @OneToMany(mappedBy = "professor")
    private List<Appointment> appointments;
}