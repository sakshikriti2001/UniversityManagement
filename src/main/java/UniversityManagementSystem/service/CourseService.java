package UniversityManagementSystem.service;

import UniversityManagementSystem.model.Course;
import java.util.List;
import java.util.Optional;

public interface CourseService {
 List<Course> getAllCourses();
 Optional<Course> getCourseById(Long id);
 Course saveCourse(Course course);
 void deleteCourse(Long id);
 Course updateCourse(Long id, Course course);
}