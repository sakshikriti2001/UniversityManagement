package UniversityManagementSystem.service;

import UniversityManagementSystem.model.Student;
import java.util.List;
import java.util.Optional;
public interface StudentService {
 List<Student> getAllStudents();
 Optional<Student> getStudentById(Long id);
 Student saveStudent(Student student);
 void deleteStudent(Long id);
 Student updateStudent(Long id, Student student);
}
