package project.lms.dto;

import project.lms.model.ExamResult;

public class ExamResultDto {
    private ExamResult examResult;
    private Long questionId;

    // 기본 생성자
    public ExamResultDto() {
    }

    // 모든 필드를 매개변수로 받는 생성자
    public ExamResultDto(ExamResult examResult, Long questionId) {
        this.examResult = examResult;
        this.questionId = questionId;
    }

    // getter, setter
    public ExamResult getExamResult() {
        return examResult;
    }

    public void setExamResult(ExamResult examResult) {
        this.examResult = examResult;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}