package UniversityManagementSystem.service;

import UniversityManagementSystem.model.Professor;
import java.util.List;
import java.util.Optional;
public interface ProfessorService {
 List<Professor> getAllProfessors();
 Optional<Professor> getProfessorById(Long id);
 Professor saveProfessor(Professor professor);
 void deleteProfessor(Long id);
 Professorr updateProfessor(Long id, Professor professor);
}