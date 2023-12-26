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
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceID;

    @ManyToOne // ManyToOne 관계 설정: 여러 개의 출석 기록은 하나의 회원 ID를 가질 수 있음
    @JoinColumn(name = "memberID", nullable = false)
    private Member memberID;

    @ManyToOne // ManyToOne 관계 설정: 여러 개의 출석 기록은 하나의 강의 ID를 가질 수 있음
    @JoinColumn(name = "courseID", nullable = false)
    private Course courseID;

    @Column(nullable = false, length = 50)
    private String status;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime checkInTime;

    @Column(nullable = true) // 퇴실 시간은 null일 수도 있음
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime checkOutTime;

    // 기본 생성자
	public Attendance() {
		super();
	}

    // 전체 생성자
	public Attendance(Long attendanceID, Member memberID, Course courseID, String status, LocalDateTime checkInTime,
			LocalDateTime checkOutTime) {
		super();
		this.attendanceID = attendanceID;
		this.memberID = memberID;
		this.courseID = courseID;
		this.status = status;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
	}

	// Getters and Setters
	public Long getAttendanceID() {
		return attendanceID;
	}

	public void setAttendanceID(Long attendanceID) {
		this.attendanceID = attendanceID;
	}

	public Member getMemberID() {
		return memberID;
	}

	public void setMemberID(Member memberID) {
		this.memberID = memberID;
	}

	public Course getCourseID() {
		return courseID;
	}

	public void setCourseID(Course courseID) {
		this.courseID = courseID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(LocalDateTime checkInTime) {
		this.checkInTime = checkInTime;
	}

	public LocalDateTime getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(LocalDateTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
    
}