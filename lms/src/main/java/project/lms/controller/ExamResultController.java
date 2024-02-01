package project.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import project.lms.dto.ExamResultDto;
import project.lms.model.ExamResult;
import project.lms.service.ExamResultService;

@RestController
@RequestMapping("/api/examResults")
@CrossOrigin(origins="http://localhost:3000",
	methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ExamResultController {

	private final ExamResultService examResultService;

	@Autowired
	public ExamResultController(ExamResultService examResultService) {
		super();
		this.examResultService = examResultService;
	}
	
	// 모든 시험 결과 조회
	@GetMapping("/list")
	@PreAuthorize("hasAnyRole('INSTRUCTOR', 'ADMIN')")
	public ResponseEntity<List<ExamResult>> getExamResultsList(){
		List<ExamResult> examResults = examResultService.getAllExamResults();
		return ResponseEntity.ok(examResults);
	}
	
	// 특정 시험 결과 조회
	@GetMapping("/list/{examResultId}")
	public ResponseEntity<ExamResult> getExamResult(@PathVariable Long examResultId){
		ExamResult examResult = examResultService.getExamResult(examResultId);
		return ResponseEntity.ok(examResult);
	}
	
	// 시험 결과 생성
	@PostMapping("/save/{examId}/{memberId}/{questionId}")
	public ResponseEntity<ExamResult> saveExamResult(@RequestBody ExamResultDto examResultDto, 
	                                                 @PathVariable Long examId, 
	                                                 @PathVariable Long memberId, 
	                                                 @PathVariable Long questionId){
	    ExamResult savedExamResult = examResultService.createExamResult(examResultDto, examId, memberId, questionId);
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedExamResult);
	}

}
