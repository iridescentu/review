package project.lms.service;

import java.util.List;

import project.lms.dto.ExamResultDto;
import project.lms.model.ExamResult;

public interface ExamResultService {
	List<ExamResult> getAllExamResults();
	
	ExamResult getExamResult(Long examResultId);
	
	ExamResult createExamResult(ExamResultDto examResultDto, Long examId, Long memberId, Long questionId);
	
	void checkAnswer(ExamResult examResult, Long questionId);
}
