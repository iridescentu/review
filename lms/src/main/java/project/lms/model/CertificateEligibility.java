package project.lms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "certificateEligibility")
public class CertificateEligibility {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eligibilityId;
	
	@ManyToOne
	@JoinColumn(name = "memberId", nullable = false)
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "courseId", nullable = false)
	private Course course;
	
	private Boolean contentCompletion;
	
	private Boolean assignmentCompletion;
	
	private Integer examScore;
	
	private Boolean isEligible;

	public CertificateEligibility() {
		super();
	}

	public CertificateEligibility(Long eligibilityId, Member member, Course course, Boolean contentCompletion,
			Boolean assignmentCompletion, Integer examScore, Boolean isEligible) {
		super();
		this.eligibilityId = eligibilityId;
		this.member = member;
		this.course = course;
		this.contentCompletion = contentCompletion;
		this.assignmentCompletion = assignmentCompletion;
		this.examScore = examScore;
		this.isEligible = isEligible;
	}

	public Long getEligibilityId() {
		return eligibilityId;
	}

	public void setEligibilityId(Long eligibilityId) {
		this.eligibilityId = eligibilityId;
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

	public Boolean getContentCompletion() {
		return contentCompletion;
	}

	public void setContentCompletion(Boolean contentCompletion) {
		this.contentCompletion = contentCompletion;
	}

	public Boolean getAssignmentCompletion() {
		return assignmentCompletion;
	}

	public void setAssignmentCompletion(Boolean assignmentCompletion) {
		this.assignmentCompletion = assignmentCompletion;
	}

	public Integer getExamScore() {
		return examScore;
	}

	public void setExamScore(Integer examScore) {
		this.examScore = examScore;
	}

	public Boolean getIsEligible() {
		return isEligible;
	}

	public void setIsEligible(Boolean isEligible) {
		this.isEligible = isEligible;
	}
	
}
