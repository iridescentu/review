package project.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import project.lms.model.Content;

public interface ContentRepository extends JpaRepository<Content, Long> {

	List<Content> findAll();

}