package project.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.lms.dto.ExamResultDto;
import project.lms.model.ExamResult;
import project.lms.service.ExamResultService;

@RestController
@RequestMapping("/exam")
@CrossOrigin(origins="http://localhost:3000",
	methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class ExamResultController {

	private final ExamResultService examResultService;

	@Autowired
	public ExamResultController(ExamResultService examResultService) {
		super();
		this.examResultService = examResultService;
	}
	
	@GetMapping("/examresult")
	public List<ExamResult> getAllExamResults(){
		return examResultService.getAllExamResults();
	}
	
	@GetMapping("/examresult/{id}")
	public ExamResult getExamResult(@PathVariable Long id) {
	    return examResultService.getExamResult(id);
	}
	
	@PostMapping("/examresult")
	public ExamResult create(@RequestBody ExamResultDto examResultDto) {
		return examResultService.createExamResult(examResultDto.getExamResult(), examResultDto.getQuestionId());
	}
}
