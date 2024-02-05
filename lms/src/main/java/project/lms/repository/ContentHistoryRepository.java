package project.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import project.lms.model.ContentHistory;
import project.lms.model.Member;

public interface ContentHistoryRepository extends JpaRepository<ContentHistory, Long> {
	
	List<ContentHistory> findByMember(Member member);
	
	List<ContentHistory> findByContentContentId(Long contentId);
	
	List<ContentHistory> findByIsCompletedTrue();
	
	List<ContentHistory> findByIsCompletedFalse();

}
