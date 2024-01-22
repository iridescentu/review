package project.lms.service;

import java.util.List;

import project.lms.dto.ResponseDto;
import project.lms.model.Content;

public interface ContentService {

    // Content 저장
    public ResponseDto<Content> saveContent(Content content);

    // 모든 Content 조회
    public ResponseDto<List<Content>> getAllContents();

    // 특정 Content 조회 by ID
    public ResponseDto<Content> getContentById(Long contentId);

    // Content 업데이트
    public ResponseDto<Content> updateContent(Long contentId, Content updatedContent);

    // Content 삭제
    public ResponseDto<String> deleteContent(Long contentId);

}
