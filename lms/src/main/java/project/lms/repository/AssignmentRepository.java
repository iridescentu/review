package project.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.lms.model.Assignment;

// JpaRepository를 상속받아야 하며, 제네릭 타입은 <엔터티, 기본키의 타입>이다.
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    // 특별한 메서드가 필요한 경우 여기에 추가할 수 있습니다.
    // 예: Assignment findByAssignmentTitle(String assignmentTitle);
}

