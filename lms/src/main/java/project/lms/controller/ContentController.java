package project.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import project.lms.dto.ResponseDto;
import project.lms.model.Content;
import project.lms.service.ContentService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
public class ContentController {

    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping("/content/save")
    public ResponseEntity<ResponseDto<Content>> saveContent(@RequestBody Content content) {
        ResponseDto<Content> response = contentService.saveContent(content);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/content/{contentId}")
    public ResponseEntity<ResponseDto<Content>> getContentById(@PathVariable Long contentId) {
        ResponseDto<Content> response = contentService.getContentById(contentId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/content")
    public ResponseEntity<ResponseDto<List<Content>>> getAllContents() {
        ResponseDto<List<Content>> response = contentService.getAllContents();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/content/update/{contentId}")
    public ResponseEntity<ResponseDto<Content>> updateContent(
            @PathVariable Long contentId,
            @RequestBody Content updatedContent) {
        ResponseDto<Content> response = contentService.updateContent(contentId, updatedContent);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/content/delete/{contentId}")
    public ResponseEntity<ResponseDto<String>> deleteContent(@PathVariable Long contentId) {
        ResponseDto<String> response = contentService.deleteContent(contentId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
