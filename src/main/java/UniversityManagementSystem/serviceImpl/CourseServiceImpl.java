package UniversityManagementSystem.serviceImpl;

import UniversityManagementSystem.exception.InvalidResourceExcception;
import UniversityManagementSystem.exception.ResourceNotFoundException;
import UniversityManagementSystem.model.Course;
import UniversityManagementSystem.repository.CourseRepository;
import UniversityManagementSystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
 @Autowired
 private CourseRepository courseRepository;
 @Override
 public List<Course> getAllCourses() {
 return courseRepository.findAll();
 }
 @Override
 public Optional<Course> getCourseById(Long id) {
 return courseRepository.findById(id);
 }
 @Override
 public Course saveCourse(Course course) {
 try {
 return courseRepository.save(course);
 } catch (Exception e) {
 throw new InvalidResourceException("Failed to save course: " + 
e.getMessage());
 }
 }
 @Override
 public void deleteCourse(Long id) {
 try {
 courseRepository.deleteById(id);
 } catch (Exception e) {
 throw new ResourceNotFoundException("Course not found with id: " + 
id);
 }
 }
 @Override
 public Course updateCourse(Long id, Course updatedCourse) {
 return courseRepository.findById(id)
 .map(existingCourse -> {
 existingCourse.setName(updatedCourse.getName());
 existingCourse.setDescription(updatedCourse.getDescription());
 // Add more fields to update as needed
 return courseRepository.save(existingCourse);
 })
 .orElseThrow(() -> new ResourceNotFoundException("Course not 
found with id: " + id));
 }
}