package project.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.lms.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	List<Course> findByCourseName(String courseName);
	
	List<Course> findByContentLevel(String contentLevel);
	
	List<Course> findByPriceBetween(Integer minPrice, Integer maxPrice);
	
	List<Course> findByDescriptionContaining(String keyword);
	
}