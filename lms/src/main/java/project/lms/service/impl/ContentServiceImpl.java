package project.lms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.lms.dto.ResponseDto;
import project.lms.enumstatus.ResultCode;
import project.lms.exception.InvalidRequestException;
import project.lms.model.Content;
import project.lms.repository.ContentRepository;
import project.lms.service.ContentService;

import java.util.List;
import java.util.Optional;

@Service
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;

    @Autowired
    public ContentServiceImpl(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Transactional
    @Override
    public ResponseDto<Content> saveContent(Content content) {
        try {
            Content savedContent = contentRepository.save(content);
            return new ResponseDto<>(ResultCode.SUCCESS.name(), savedContent, "Content saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            throw new InvalidRequestException("Error saving content.", e.getMessage());
        }
    }

    @Override
    public ResponseDto<List<Content>> getAllContents() {
        List<Content> contents = contentRepository.findAll();
        return new ResponseDto<>(ResultCode.SUCCESS.name(), contents, "All contents retrieved successfully.");
    }

    @Override
    public ResponseDto<Content> getContentById(Long contentId) {
        Optional<Content> optionalContent = contentRepository.findById(contentId);
        return optionalContent.map(content -> new ResponseDto<>(ResultCode.SUCCESS.name(), content, "Content retrieved successfully."))
                .orElseGet(() -> new ResponseDto<>(ResultCode.ERROR.name(), null, "Content not found."));
    }

    @Transactional
    @Override
    public ResponseDto<Content> updateContent(Long contentId, Content updatedContent) {
        try {
            Optional<Content> optionalContent = contentRepository.findById(contentId);

            if (optionalContent.isPresent()) {
                Content existingContent = optionalContent.get();

                // Content 업데이트 로직
                existingContent.setContentTitle(updatedContent.getContentTitle());
                existingContent.setContentDescription(updatedContent.getContentDescription());
                existingContent.setContentImg(updatedContent.getContentImg());
                existingContent.setContentDuration(updatedContent.getContentDuration());
                existingContent.setContentStatus(updatedContent.isContentStatus());

                contentRepository.save(existingContent);

                return new ResponseDto<>(ResultCode.SUCCESS.name(), null, "Content updated successfully.");
            } else {
                return new ResponseDto<>(ResultCode.ERROR.name(), null, "Content not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new InvalidRequestException("Error updating content.", e.getMessage());
        }
    }

    @Transactional
    @Override
    public ResponseDto<String> deleteContent(Long contentId) {
        try {
            Optional<Content> optionalContent = contentRepository.findById(contentId);

            if (optionalContent.isPresent()) {
                contentRepository.deleteById(contentId);
                return new ResponseDto<>(ResultCode.SUCCESS.name(), null, "Content deleted successfully.");
            } else {
                return new ResponseDto<>(ResultCode.ERROR.name(), null, "Content not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new InvalidRequestException("Error deleting content.", e.getMessage());
        }
    }
}
