package project.lms.dto;

import project.lms.model.Course;

public class ContentDto {
	
	private Long contentId;
	
	private Course course;
	
	private String contentTitle;
	
	private String contentType;
	
	private String contentData;
	
	private String contentURL;
	
	private Integer contentDuration;
	
	private String contentStatus;
	
	private Integer sequenceOrder;

	public ContentDto() {
		super();
	}

	public ContentDto(Long contentId, Course course, String contentTitle, String contentType, String contentData,
			String contentURL, Integer contentDuration, String contentStatus, Integer sequenceOrder) {
		super();
		this.contentId = contentId;
		this.course = course;
		this.contentTitle = contentTitle;
		this.contentType = contentType;
		this.contentData = contentData;
		this.contentURL = contentURL;
		this.contentDuration = contentDuration;
		this.contentStatus = contentStatus;
		this.sequenceOrder = sequenceOrder;
	}

	public Long getContentId() {
		return contentId;
	}

	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentData() {
		return contentData;
	}

	public void setContentData(String contentData) {
		this.contentData = contentData;
	}

	public String getContentURL() {
		return contentURL;
	}

	public void setContentURL(String contentURL) {
		this.contentURL = contentURL;
	}

	public Integer getContentDuration() {
		return contentDuration;
	}

	public void setContentDuration(Integer contentDuration) {
		this.contentDuration = contentDuration;
	}

	public String getContentStatus() {
		return contentStatus;
	}

	public void setContentStatus(String contentStatus) {
		this.contentStatus = contentStatus;
	}

	public Integer getSequenceOrder() {
		return sequenceOrder;
	}

	public void setSequenceOrder(Integer sequenceOrder) {
		this.sequenceOrder = sequenceOrder;
	}


}
