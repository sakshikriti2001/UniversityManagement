package UniversityManagementSystem.repository;

import UniversityManagementSystem.model.Professor; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
}
