package project.lms.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "course_history")
public class CourseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseHistoryId;

    @ManyToOne // ManyToOne 관계 설정: 여러 개의 과정 이력은 하나의 회원 ID를 가질 수 있음
    @JoinColumn(name = "memberId", nullable = false)
    private Member member;

    @ManyToOne // ManyToOne 관계 설정: 여러 개의 과정 이력은 하나의 강의 ID를 가질 수 있음
    @JoinColumn(name = "courseId", nullable = false)
    private Course course;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startDate; // 강의 시작 날짜를 저장

    // 기본 생성자
	public CourseHistory() {
		super();
	}

	// 전체 생성자
	public CourseHistory(Long courseHistoryId, Member member, Course course, LocalDateTime startDate) {
		super();
		this.courseHistoryId = courseHistoryId;
		this.member = member;
		this.course = course;
		this.startDate = startDate;
	}

	// Getters and Setters
	public Long getCourseHistoryId() {
		return courseHistoryId;
	}

	public void setCourseHistoryId(Long courseHistoryId) {
		this.courseHistoryId = courseHistoryId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
    
}