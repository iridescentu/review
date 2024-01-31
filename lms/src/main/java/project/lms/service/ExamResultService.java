package project.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.lms.exception.InvalidRequestException;
import project.lms.model.ExamQuestion;
import project.lms.model.ExamResult;
import project.lms.repository.ExamQuestionRepository;
import project.lms.repository.ExamResultRepository;

@Service
public class ExamResultService {

	private final ExamResultRepository examResultRepository;
	private final ExamQuestionRepository examQuestionRepository;

    // 생성자를 통해 필요한 Repository를 주입받음
	public ExamResultService(ExamResultRepository examResultRepository, ExamQuestionRepository examQuestionRepository) {
		super();
		this.examResultRepository = examResultRepository;
		this.examQuestionRepository = examQuestionRepository;
	}
	
    // 모든 시험 결과를 조회하는 메서드
	public List<ExamResult> getAllExamResults(){
		return examResultRepository.findAll();
	}
	
	public ExamResult getExamResult(Long examResultId) {
	    return examResultRepository.findById(examResultId)
	        .orElseThrow(() -> new InvalidRequestException("ExamResult not found", "해당 시험 결과를 찾을 수 없습니다."));
	}

    // 시험 결과를 생성하는 메서드
    // 이 메서드는 사용자가 답안을 제출할 때 호출
	public ExamResult createExamResult(ExamResult examResult, Long questionId) {
        // 답안을 제출한 후에는 제출한 답안이 정답인지 확인해야 함
        // 이를 위해 checkAnswer 메서드를 호출
		checkAnswer(examResult, questionId);
        // 그 후, 시험 결과를 저장하고 반환
		return examResultRepository.save(examResult);
	}
	
    // 사용자가 제출한 답안이 정답인지 확인하는 메서드
	public void checkAnswer(ExamResult examResult, Long questionId) {
        // 먼저 해당 시험 문제를 조회
		ExamQuestion examQuestion = examQuestionRepository.findById(questionId)
		        .orElseThrow(() -> new InvalidRequestException("ExamQuestion not found", "해당 시험 문제를 찾을 수 없습니다."));

        // 제출한 답안이 정답인지 확인
		if (examQuestion.getCorrectOptionIndex().equals(examResult.getSubmittedAnswer())) {
            // 제출한 답안이 정답인 경우, isCorrect를 true로 설정
			examResult.setCorrect(true);
		} else {
            // 제출한 답안이 정답이 아닌 경우, isCorrect를 false로 설정
			examResult.setCorrect(false);
		}
	}

}
