package project.lms.model;

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

import java.sql.Timestamp;

@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId;

    @ManyToOne
    @JoinColumn(name = "courseId", nullable = false)
    private Course course;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp dueDate;

    @Column(name = "assignmentTitle", length = 200, nullable = false)
    private String assignmentTitle;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "passingScore", nullable = false)
    private Integer passingScore;

    @Column(name = "assignIsActive", nullable = false)
    private boolean assignIsActive;

    // 기본 생성자
    public Assignment() {
    }

    // 전체 생성자
    public Assignment(Long assignmentId, Course course, Timestamp dueDate, String assignmentTitle,
                      String description, Integer passingScore, boolean assignIsActive) {
        this.assignmentId = assignmentId;
        this.course = course;
        this.dueDate = dueDate;
        this.assignmentTitle = assignmentTitle;
        this.description = description;
        this.passingScore = passingScore;
        this.assignIsActive = assignIsActive;
    }

    // Getters and Setters
    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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
}
