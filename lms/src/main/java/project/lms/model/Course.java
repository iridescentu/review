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
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @ManyToOne // ManyToOne 관계 설정: 하나의 강의는 여러 회원 ID를 가질 수 있음
    @JoinColumn(name = "memberId", nullable = false)
    private Member member;

    @Column(nullable = false, length = 150)
    private String courseName;

    @Column(nullable = true, length = 500) // 강의 소개는 필수가 아닐 수 있음
    private String description;

    @ManyToOne // ManyToOne 관계 설정: 하나의 강의는 여러 강사 ID를 가질 수 있음
    @JoinColumn(name = "instructorId", nullable = false)
    private Instructor instructor;

    @Column(nullable = false)
    private Integer durationMins;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startDate;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endDate;

    // 기본 생성자
    public Course() {
        super();
    }

    // 전체 생성자
	public Course(Long courseId, Member member, String courseName, String description, Instructor instructor,
			Integer durationMins, LocalDateTime startDate, LocalDateTime endDate) {
		super();
		this.courseId = courseId;
		this.member = member;
		this.courseName = courseName;
		this.description = description;
		this.instructor = instructor;
		this.durationMins = durationMins;
		this.startDate = startDate;
		this.endDate = endDate;
	}

    // Getters and Setters
	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Integer getDurationMins() {
		return durationMins;
	}

	public void setDurationMins(Integer durationMins) {
		this.durationMins = durationMins;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

}