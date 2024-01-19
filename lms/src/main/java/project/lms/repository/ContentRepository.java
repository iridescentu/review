package project.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import project.lms.model.Content;

public interface ContentRepository extends JpaRepository<Content, Long> {

	 List<Content> findByCourse_CourseId(Long courseId);
	 
	 Optional<Content> findByCourse_CourseIdAndSequenceOrder(Long courseId, Integer sequenceOrder);
	 
	 List<Content> findByCourse_CourseIdAndContentType(Long courseId, String contentType);
}