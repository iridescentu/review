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
@Table(name = "assignments")
public class Assignment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId;
    
    @ManyToOne
    @JoinColumn(name = "contentId", nullable = false)
    private Content content;
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp dueDate;
    
    @Column(length = 200, nullable = false)
    private String assignmentTitle;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column(nullable = false)
    private Integer passingScore;
    
    @Column(name = "assignIsActive")
    private boolean assignIsActive;
    
    @Column(name = "assignSubmissionTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp assignSubmissionTime;
    
    @Column(name = "assignCompletionStatus")
    private boolean assignCompletionStatus;
    
    @Column(name = "assignScore")
    private Integer assignScore;

    // 기본 생성자
    public Assignment() {
  
    }

    // 전체 생성자
    public Assignment(Long assignmentId, Content content, Timestamp dueDate, String assignmentTitle, String description, 
                      Integer passingScore, boolean assignIsActive, Timestamp assignSubmissionTime, 
                      boolean assignCompletionStatus, Integer assignScore) {
        this.assignmentId = assignmentId;
        this.content = content;
        this.dueDate = dueDate;
        this.assignmentTitle = assignmentTitle;
        this.description = description;
        this.passingScore = passingScore;
        this.assignIsActive = assignIsActive;
        this.assignSubmissionTime = assignSubmissionTime;
        this.assignCompletionStatus = assignCompletionStatus;
        this.assignScore = assignScore;
    }

    // Getters and Setters
	public Long getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public Timestamp getDueDate() {
		return dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public String getAssignmentTitle() {
		return assignmentTitle;
	}

	public void setAssignmentTitle(String assignmentTitle) {
		this.assignmentTitle = assignmentTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPassingScore() {
		return passingScore;
	}

	public void setPassingScore(Integer passingScore) {
		this.passingScore = passingScore;
	}

	public boolean isAssignIsActive() {
		return assignIsActive;
	}

	public void setAssignIsActive(boolean assignIsActive) {
		this.assignIsActive = assignIsActive;
	}

	public Timestamp getAssignSubmissionTime() {
		return assignSubmissionTime;
	}

	public void setAssignSubmissionTime(Timestamp assignSubmissionTime) {
		this.assignSubmissionTime = assignSubmissionTime;
	}

	public boolean isAssignCompletionStatus() {
		return assignCompletionStatus;
	}

	public void setAssignCompletionStatus(boolean assignCompletionStatus) {
		this.assignCompletionStatus = assignCompletionStatus;
	}

	public Integer getAssignScore() {
		return assignScore;
	}

	public void setAssignScore(Integer assignScore) {
		this.assignScore = assignScore;
	}	

}
