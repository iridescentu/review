package project.lms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "assignQuestions")
public class AssignQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long assignQuestionId;
	
	@ManyToOne
	@JoinColumn(name = "assignmentId", nullable = false)
	private Assignment assignment;
	
	private Long questionText;
	
	private Long[] options;
	
	private Integer correctOptionIndex;

	public AssignQuestion() {
		super();
	}

	public AssignQuestion(Long assignQuestionId, Assignment assignment, Long questionText, Long[] options,
			Integer correctOptionIndex) {
		super();
		this.assignQuestionId = assignQuestionId;
		this.assignment = assignment;
		this.questionText = questionText;
		this.options = options;
		this.correctOptionIndex = correctOptionIndex;
	}

	public Long getAssignQuestionId() {
		return assignQuestionId;
	}

	public void setAssignQuestionId(Long assignQuestionId) {
		this.assignQuestionId = assignQuestionId;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public Long getQuestionText() {
		return questionText;
	}

	public void setQuestionText(Long questionText) {
		this.questionText = questionText;
	}

	public Long[] getOptions() {
		return options;
	}

	public void setOptions(Long[] options) {
		this.options = options;
	}

	public Integer getCorrectOptionIndex() {
		return correctOptionIndex;
	}

	public void setCorrectOptionIndex(Integer correctOptionIndex) {
		this.correctOptionIndex = correctOptionIndex;
	}
	
}
