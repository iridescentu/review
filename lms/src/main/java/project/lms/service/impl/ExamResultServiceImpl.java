package project.lms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.lms.dto.ExamResultDto;
import project.lms.exception.InvalidRequestException;
import project.lms.model.Exam;
import project.lms.model.ExamQuestion;
import project.lms.model.ExamResult;
import project.lms.model.Member;
import project.lms.repository.ExamQuestionRepository;
import project.lms.repository.ExamRepository;
import project.lms.repository.ExamResultRepository;
import project.lms.repository.MemberRepository;
import project.lms.service.ExamResultService;

@Service
public class ExamResultServiceImpl implements ExamResultService {

	@Autowired
	private final ExamResultRepository examResultRepository;
	@Autowired
	private final ExamQuestionRepository examQuestionRepository;
	@Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ExamRepository examRepository;
	
	public ExamResultServiceImpl(ExamResultRepository examResultRepository, ExamQuestionRepository examQuestionRepository) {
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
	@Override
	public ExamResult createExamResult(ExamResultDto examResultDto, Long examId, Long memberId, Long questionId) {
	    // memberId와 examId를 이용하여 Member와 Exam 객체를 조회
	    Member member = memberRepository.findById(memberId)
	        .orElseThrow(() -> new InvalidRequestException("Member not found", "해당 회원을 찾을 수 없습니다."));
	    Exam exam = examRepository.findById(examId)
	        .orElseThrow(() -> new InvalidRequestException("Exam not found", "해당 시험을 찾을 수 없습니다."));
	    
	    // ExamResultDto에서 받아온 데이터를 ExamResult에 설정
	    ExamResult examResult = new ExamResult();
	    examResult.setMember(member);
	    examResult.setExam(exam);
	    examResult.setSubmittedAnswer(examResultDto.getSubmittedAnswer());
	    examResult.setWrongAnsExpl(examResultDto.getWrongAnsExpl());

	    checkAnswer(examResult, questionId);
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
