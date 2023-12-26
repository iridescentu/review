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
    private Long courseID;

    @ManyToOne // ManyToOne 관계 설정: 하나의 강의는 하나의 회원 ID를 가질 수 있음
    @JoinColumn(name = "memberID", nullable = false)
    private Member memberID;

    @Column(nullable = false, length = 150)
    private String courseName;

    @Column(nullable = true, length = 500) // 강의 소개는 필수가 아닐 수 있음
    private String description;

    @ManyToOne // ManyToOne 관계 설정: 하나의 강의는 하나의 강사 ID를 가질 수 있음
    @JoinColumn(name = "instructorID", nullable = false)
    private Instructor instructorID;

    @Column(nullable = false)
    private Integer durationMins;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startDate;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endDate;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME) // 강의 기한은 시간만 포함하므로 TIME 사용
    private LocalDateTime deadline;

    // 기본 생성자
    public Course() {
        super();
    }

    // 전체 생성자
	public Course(Long courseID, Member memberID, String courseName, String description, Instructor instructorID,
			Integer durationMins, LocalDateTime startDate, LocalDateTime endDate, LocalDateTime deadline) {
		super();
		this.courseID = courseID;
		this.memberID = memberID;
		this.courseName = courseName;
		this.description = description;
		this.instructorID = instructorID;
		this.durationMins = durationMins;
		this.startDate = startDate;
		this.endDate = endDate;
		this.deadline = deadline;
	}

    // Getters and Setters
	public Long getCourseID() {
		return courseID;
	}

	public void setCourseID(Long courseID) {
		this.courseID = courseID;
	}

	public Member getMemberID() {
		return memberID;
	}

	public void setMemberID(Member memberID) {
		this.memberID = memberID;
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

	public Instructor getInstructorID() {
		return instructorID;
	}

	public void setInstructorID(Instructor instructorID) {
		this.instructorID = instructorID;
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

	public LocalDateTime getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}

}