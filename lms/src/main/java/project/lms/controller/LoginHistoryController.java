//package project.lms.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import project.lms.dto.ResponseDto;
//import project.lms.model.LoginHistory;
//import project.lms.model.Member;
//import project.lms.service.LoginHistoryService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.GET })
//public class LoginHistoryController {
//
//    private final LoginHistoryService loginHistoryService;
//
//    @Autowired
//    public LoginHistoryController(LoginHistoryService loginHistoryService) {
//        this.loginHistoryService = loginHistoryService;
//    }
//
//    // 전체 회원의 로그인 이력을 조회하는 엔드포인트
//    @PreAuthorize("hasAnyRole('ADMIN')")
//    @GetMapping("/loginhistory/all")
//    public ResponseEntity<ResponseDto<List<LoginHistory>>> getAllLoginHistories() {
//        ResponseDto<List<LoginHistory>> responseDto = loginHistoryService.getAllLoginHistories();
//        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
//    }
//
//    // 특정 회원의 로그인 이력을 조회하는 엔드포인트
//    @PreAuthorize("hasAnyRole('ADMIN')")
//    @GetMapping("/loginhistory/member/{memberId}")
//    public ResponseEntity<ResponseDto<List<LoginHistory>>> getLoginHistoryByMemberId(@PathVariable Long memberId) {
//        Member member = new Member();
//        member.setMemberId(memberId);
//        ResponseDto<List<LoginHistory>> responseDto = loginHistoryService.getLoginHistoryByMemberId(member);
//        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
//    }
//
//}
