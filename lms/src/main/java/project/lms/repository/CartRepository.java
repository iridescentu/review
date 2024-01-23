package project.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.lms.model.Cart;
import project.lms.model.Course;
import project.lms.model.Member;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    // 특정 회원의 장바구니 조회
    List<Cart> findByMember(Member member);

    // 특정 회원의 특정 강의가 포함된 장바구니 조회
    Optional<Cart> findByMemberAndCourse(Member member, Course course);

    // 특정 회원의 모든 장바구니 비우기
    void deleteByMember(Member member);

}
