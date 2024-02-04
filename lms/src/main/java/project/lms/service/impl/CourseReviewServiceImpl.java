package project.lms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.lms.dto.CourseReviewDto;
import project.lms.repository.CourseReviewRepository;
import project.lms.repository.MemberRepository;
import project.lms.service.CourseReviewService;
import project.lms.repository.CourseRepository;
import project.lms.model.Member;
import project.lms.model.Course;
import project.lms.model.CourseReview;
import project.lms.exception.InvalidRequestException;

import java.util.List;
import java.util.stream.Collectors;

@Service // 이 클래스가 서비스 레이어의 컴포넌트임을 나타냄
public class CourseReviewServiceImpl implements CourseReviewService {

    @Autowired // 의존성 주입
    private CourseReviewRepository courseReviewRepository;

    @Autowired // 의존성 주입
    private MemberRepository memberRepository;

    @Autowired // 의존성 주입
    private CourseRepository courseRepository;

    // 생성자
    public CourseReviewServiceImpl(CourseReviewRepository courseReviewRepository, MemberRepository memberRepository, CourseRepository courseRepository) {
        super();
        this.courseReviewRepository = courseReviewRepository;
        this.memberRepository = memberRepository;
        this.courseRepository = courseRepository;
    }

    // 모든 리뷰를 조회하여 CourseReviewDto 리스트로 반환하는 메서드
    @Override
    public List<CourseReviewDto> getAllReviews() {
        return courseReviewRepository.findAll().stream().map(CourseReviewDto::from).collect(Collectors.toList());
    }

    // reviewId를 기반으로 해당 리뷰를 조회하여 CourseReviewDto로 반환하는 메서드
    @Override
    public CourseReviewDto getCourseReview(Long reviewId) {
        return CourseReviewDto.from(courseReviewRepository.findById(reviewId)
            .orElseThrow(() -> new InvalidRequestException("Review not found", "해당 수강평을 찾을 수 없습니다.")));
    }

    // memberId를 기반으로 해당 사용자의 모든 리뷰를 조회하여 CourseReviewDto 리스트로 반환하는 메서드
    @Override
    public List<CourseReviewDto> getReviewsByMemberId(Long memberId) {
        return courseReviewRepository.findByMember_MemberId(memberId).stream().map(CourseReviewDto::from).collect(Collectors.toList());
    }

    // courseId를 기반으로 해당 강의의 모든 리뷰를 조회하여 CourseReviewDto 리스트로 반환하는 메서드
    @Override
    public List<CourseReviewDto> getReviewsByCourseId(Long courseId) {
        return courseReviewRepository.findByCourse_CourseId(courseId).stream().map(CourseReviewDto::from).collect(Collectors.toList());
    }

    // 리뷰를 생성하고, 저장한 후 CourseReviewDto로 반환하는 메서드
    @Override
    public CourseReviewDto saveCourseReview(CourseReviewDto courseReviewDto) {
        Member member = memberRepository.findById(courseReviewDto.getMemberId())
            .orElseThrow(() -> new InvalidRequestException("Member not found", "해당 회원을 찾을 수 없습니다."));
        Course course = courseRepository.findById(courseReviewDto.getCourseId())
            .orElseThrow(() -> new InvalidRequestException("Course not found", "해당 강의를 찾을 수 없습니다."));

        if (!course.getMembers().contains(member)) {
            throw new InvalidRequestException("Invalid Course", "회원이 수강 중이지 않은 강의에 대해 수강평을 작성할 수 없습니다.");
        }

        CourseReview courseReview = new CourseReview();
        courseReview.setMember(member);
        courseReview.setCourse(course);
        courseReview.setComment(courseReviewDto.getComment());
        courseReview = courseReviewRepository.save(courseReview);
        return CourseReviewDto.from(courseReview);
    }


    // 리뷰를 업데이트하고, 업데이트된 리뷰를 CourseReviewDto로 반환하는 메서드
    @Override
    public CourseReviewDto updateCourseReview(CourseReviewDto courseReviewDto) {
        CourseReview courseReview = courseReviewRepository.findById(courseReviewDto.getReviewId())
            .orElseThrow(() -> new InvalidRequestException("Review not found", "해당 수강평을 찾을 수 없습니다."));
        courseReview.setContent(courseReviewDto.getContent());
        courseReview = courseReviewRepository.save(courseReview);
        return CourseReviewDto.from(courseReview);
    }

    // 리뷰를 삭제하는 메서드
    @Override
    public void deleteCourseReview(Long reviewId) {
        if (!courseReviewRepository.existsById(reviewId)) {
            throw new InvalidRequestException("Review not found", "해당 수강평을 찾을 수 없습니다.");
        }
        courseReviewRepository.deleteById(reviewId);
    }
}
