package project.lms.dto;

import project.lms.model.Exam;
import project.lms.model.ExamHistory;
import project.lms.model.Member;

public class ExamHistoryDto {

    private Long examHistoryId;
    private MemberDto member;
    private ExamDto exam;
    private boolean examCompletionStatus;

    public ExamHistoryDto() {
    }

    public ExamHistoryDto(Long examHistoryId, MemberDto member, ExamDto exam, boolean examCompletionStatus) {
        this.examHistoryId = examHistoryId;
        this.member = member;
        this.exam = exam;
        this.examCompletionStatus = examCompletionStatus;
    }

    public Long getExamHistoryId() {
        return examHistoryId;
    }

    public void setExamHistoryId(Long examHistoryId) {
        this.examHistoryId = examHistoryId;
    }

    public MemberDto getMember() {
        return member;
    }

    public void setMember(MemberDto member) {
        this.member = member;
    }

    public ExamDto getExam() {
        return exam;
    }

    public void setExam(ExamDto exam) {
        this.exam = exam;
    }

    public boolean isExamCompletionStatus() {
        return examCompletionStatus;
    }

    public void setExamCompletionStatus(boolean examCompletionStatus) {
        this.examCompletionStatus = examCompletionStatus;
    }

    public static ExamHistoryDto from(ExamHistory examHistory) {
        return new ExamHistoryDto(
            examHistory.getExamHistoryId(),
            MemberDto.from(examHistory.getMember()),
            new ExamDto(examHistory.getExam().getContent().getContentId(), examHistory.getExam().getExamIsActive()),
            examHistory.isExamCompletionStatus()
        );
    }
}
