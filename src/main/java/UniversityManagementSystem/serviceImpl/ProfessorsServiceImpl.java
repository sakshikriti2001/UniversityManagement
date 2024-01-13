package UniversityManagementSystem.serviceImpl;

import UniversityManagementSystem.exception.InvalidResourceException;
import UniversityManagementSystem.exception.ResourceNotFoundException;
import UniversityManagementSystem.model.Instructor;
import UniversityManagementSystem.repository.InstructorRepository;
import UniversityManagementSystem.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ProfessorServiceImpl implements ProfessorService {
 @Autowired
 private ProfessorRepository ProfessorRepository;
 @Override
 public List<Professor> getAllProfessors() {
 return professorRepository.findAll();
 }
 @Override
 public Optional<Professor> getProfessorById(Long id) {
 return professorRepository.findById(id);
 }
 @Override
 public Professor saveProfessor(Professor professor) {
 try {
 return professorRepository.save(professor);
 } catch (Exception e) {
 throw new InvalidResourceException("Failed to save professor: " + e.getMessage());
 }
 }
 @Override
 public void deleteProfessor(Long id) {
 try {
 professorRepository.deleteById(id);
 } catch (Exception e) {
 throw new ResourceNotFoundException("Professor not found with id: " + id);
 }
 }
 @Override
 public Professor updateProfessor(Long id, Professor updatedProfessor) {
	    return professorRepository.findById(id)
	            .map(existingProfessor -> {
	                existingProfessor.setFirstName(updatedProfessor.getFirstName());
	                existingProfessor.setLastName(updatedProfessor.getLastName());
	                existingProfessor.setDepartment(updatedProfessor.getDepartment());
	                existingProfessor.setContactNumber(updatedProfessor.getContactNumber());
	                existingProfessor.setAddress(updatedProfessor.getAddress());
	                existingProfessor.setSalary(updatedProfessor.getSalary());
	                return professorRepository.save(existingProfessor);
	            })
	            .orElseThrow(() -> new ResourceNotFoundException("Professor not found with id: " + id));
	}
}