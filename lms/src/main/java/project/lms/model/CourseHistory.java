package project.lms.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "courseHistory")
public class CourseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseHistoryId;

    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "courseId", nullable = false)
    private Course course;

    private LocalDate startDate;
    
    private LocalDate endDate;
    
    private boolean contentStatus;

    // 기본 생성자
    public CourseHistory() {
    }

	public CourseHistory(Long courseHistoryId, Member member, Course course, LocalDate startDate, LocalDate endDate,
			boolean contentStatus) {
		super();
		this.courseHistoryId = courseHistoryId;
		this.member = member;
		this.course = course;
		this.startDate = startDate;
		this.endDate = endDate;
		this.contentStatus = contentStatus;
	}

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

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public boolean isContentStatus() {
		return contentStatus;
	}

	public void setContentStatus(boolean contentStatus) {
		this.contentStatus = contentStatus;
	}

}
