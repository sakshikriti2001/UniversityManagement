package UniversityManagementSystem.serviceImpl;

import UniversityManagementSystem.exception.InvalidResourceException;
import UniversityManagementSystem.exception.ResourceNotFoundException;
import UniversityManagementSystem.model.Student;
import UniversityManagementSystem.repository.StudentRepository;
import UniversityManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {
 @Autowired
 private StudentRepository studentRepository;
 @Override
 public List<Student> getAllStudents() {
 return studentRepository.findAll();
 }
 @Override
 public Optional<Student> getStudentById(Long id) {
 return studentRepository.findById(id);
 }
 @Override
 public Student saveStudent(Student student) {
 try {
 return studentRepository.save(student);
 } catch (Exception e) {
 throw new InvalidResourceException("Failed to save student: " + e.getMessage());
 }
 }
@Override
 public void deleteStudent(Long id) {
 try {
 studentRepository.deleteById(id);
 } catch (Exception e) {
 throw new ResourceNotFoundException("Student not found with id: " + id);
 }
 }
 @Override
 public Student updateStudent(Long id, Student updatedStudent) {
 return studentRepository.findById(id)
 .map(existingStudent -> {
 existingStudent.setName(updatedStudent.getName());
 existingStudent.setGender(updatedStudent.getGender());
 existingStudent.setAge(updatedStudent.getAge());
 existingStudent.setContactInfo(updatedStudent.getContactInfo());
 existingStudent.setMajor(updatedStudent.getMajor());
 return studentRepository.save(existingStudent);
 })
 .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
 }
}
