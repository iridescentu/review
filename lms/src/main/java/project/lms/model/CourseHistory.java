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

    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "courseId", nullable = false)
    private Course course;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startDate;

    @ManyToOne
    @JoinColumn(name = "examId")
    private Exam exam;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime examDate;

    @Column
    private Boolean examIsActive;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime examSubmissionTime;

    @Column
    private Boolean examCompletionStatus;

    @Column
    private Integer examScore;

    @ManyToOne
    @JoinColumn(name = "assignmentId")
    private Assignment assignment;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dueDate;

    @Column
    private Boolean assignIsActive;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime assignSubmissionTime;

    @Column
    private Boolean assignCompletionStatus;

    @Column
    private Integer assignScore;

    // 기본 생성자
	public CourseHistory() {
		super();
	}

	// 전체 생성자
	public CourseHistory(Long courseHistoryId, Member member, Course course, LocalDateTime startDate, Exam exam,
			LocalDateTime examDate, Boolean examIsActive, LocalDateTime examSubmissionTime,
			Boolean examCompletionStatus, Integer examScore, Assignment assignment, LocalDateTime dueDate,
			Boolean assignIsActive, LocalDateTime assignSubmissionTime, Boolean assignCompletionStatus,
			Integer assignScore) {
		super();
		this.courseHistoryId = courseHistoryId;
		this.member = member;
		this.course = course;
		this.startDate = startDate;
		this.exam = exam;
		this.examDate = examDate;
		this.examIsActive = examIsActive;
		this.examSubmissionTime = examSubmissionTime;
		this.examCompletionStatus = examCompletionStatus;
		this.examScore = examScore;
		this.assignment = assignment;
		this.dueDate = dueDate;
		this.assignIsActive = assignIsActive;
		this.assignSubmissionTime = assignSubmissionTime;
		this.assignCompletionStatus = assignCompletionStatus;
		this.assignScore = assignScore;
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

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public LocalDateTime getExamDate() {
		return examDate;
	}

	public void setExamDate(LocalDateTime examDate) {
		this.examDate = examDate;
	}

	public Boolean getExamIsActive() {
		return examIsActive;
	}

	public void setExamIsActive(Boolean examIsActive) {
		this.examIsActive = examIsActive;
	}

	public LocalDateTime getExamSubmissionTime() {
		return examSubmissionTime;
	}

	public void setExamSubmissionTime(LocalDateTime examSubmissionTime) {
		this.examSubmissionTime = examSubmissionTime;
	}

	public Boolean getExamCompletionStatus() {
		return examCompletionStatus;
	}

	public void setExamCompletionStatus(Boolean examCompletionStatus) {
		this.examCompletionStatus = examCompletionStatus;
	}

	public Integer getExamScore() {
		return examScore;
	}

	public void setExamScore(Integer examScore) {
		this.examScore = examScore;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public Boolean getAssignIsActive() {
		return assignIsActive;
	}

	public void setAssignIsActive(Boolean assignIsActive) {
		this.assignIsActive = assignIsActive;
	}

	public LocalDateTime getAssignSubmissionTime() {
		return assignSubmissionTime;
	}

	public void setAssignSubmissionTime(LocalDateTime assignSubmissionTime) {
		this.assignSubmissionTime = assignSubmissionTime;
	}

	public Boolean getAssignCompletionStatus() {
		return assignCompletionStatus;
	}

	public void setAssignCompletionStatus(Boolean assignCompletionStatus) {
		this.assignCompletionStatus = assignCompletionStatus;
	}

	public Integer getAssignScore() {
		return assignScore;
	}

	public void setAssignScore(Integer assignScore) {
		this.assignScore = assignScore;
	}

    
}
