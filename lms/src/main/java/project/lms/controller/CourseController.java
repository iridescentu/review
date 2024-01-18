package project.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.lms.dto.CourseDto;
import project.lms.model.Course;
import project.lms.service.CourseService;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins="http://localhost:3000",
methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class CourseController {

	private final CourseService courseService;
	
	@Autowired
	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
	@GetMapping("/course")
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@PostMapping("/course")
	public Course createCourse(@RequestBody Course course) {
		return courseService.createCourse(course);
	}
	
	// 강의 정보 조회를 위한 엔드포인트
    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDto> getCourse(@PathVariable Long courseId) {
        Course course = courseService.getCourseById(courseId);
        
        // Course 엔터티를 CourseDto로 변환
        CourseDto courseDto = CourseDto.fromEntity(course);
        
        return ResponseEntity.ok(courseDto);
    }
	
}