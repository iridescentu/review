package project.lms.model;

import java.sql.Timestamp;

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
@Table(name = "Exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examID;

    @ManyToOne
    @JoinColumn(name = "courseID", nullable = false)
    private Course course;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp examDate;

    @Column(nullable = false)
    private Integer numQuestions;

    @Column(nullable = false)
    private Integer durationMins;

    @Column(nullable = false)
    private Integer passingScore;

    @Column(name = "examIsActive")
    private Boolean examIsActive;

    @Column(name = "examSubmissionTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp examSubmissionTime;

    @Column(name = "examCompletionStatus")
    private Boolean examCompletionStatus;

    @Column(name = "examScore")
    private Integer examScore;

    // 기본 생성자
    public Exam() {
    }

    // 전체 생성자
    public Exam(Long examID, Course course, Timestamp examDate, Integer numQuestions, Integer durationMins,
                Integer passingScore, Boolean examIsActive, Timestamp examSubmissionTime, 
                Boolean examCompletionStatus, Integer examScore) {
        this.examID = examID;
        this.course = course;
        this.examDate = examDate;
        this.numQuestions = numQuestions;
        this.durationMins = durationMins;
        this.passingScore = passingScore;
        this.examIsActive = examIsActive;
        this.examSubmissionTime = examSubmissionTime;
        this.examCompletionStatus = examCompletionStatus;
        this.examScore = examScore;
    }

    // Getters and Setters
	public Long getExamID() {
		return examID;
	}

	public void setExamID(Long examID) {
		this.examID = examID;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Timestamp getExamDate() {
		return examDate;
	}

	public void setExamDate(Timestamp examDate) {
		this.examDate = examDate;
	}

	public Integer getNumQuestions() {
		return numQuestions;
	}

	public void setNumQuestions(Integer numQuestions) {
		this.numQuestions = numQuestions;
	}

	public Integer getDurationMins() {
		return durationMins;
	}

	public void setDurationMins(Integer durationMins) {
		this.durationMins = durationMins;
	}

	public Integer getPassingScore() {
		return passingScore;
	}

	public void setPassingScore(Integer passingScore) {
		this.passingScore = passingScore;
	}

	public Boolean getExamIsActive() {
		return examIsActive;
	}

	public void setExamIsActive(Boolean examIsActive) {
		this.examIsActive = examIsActive;
	}

	public Timestamp getExamSubmissionTime() {
		return examSubmissionTime;
	}

	public void setExamSubmissionTime(Timestamp examSubmissionTime) {
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

}
