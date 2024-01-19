package project.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contents")
public class Content {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contentId;

    @ManyToOne
    @JoinColumn(name = "courseId", nullable = false)
    private Course course;

    @Column(name = "contentTitle", length = 30, nullable = false)
    private String contentTitle;

    @Column(name = "contentDescription", columnDefinition = "TEXT")
    private String contentDescription;

    @Column(name = "contentType", length = 50, nullable = false)
    private String contentType;

    @Column
    private String contentData;

    @Column(name = "contentURL")
    private String contentURL;

    @Column(name = "contentDuration")
    private Integer contentDuration;

    @Column(name = "contentStatus", length = 50)
    private String contentStatus;

    @Column(name = "sequenceOrder")
    private Integer sequenceOrder;


	public Content() {
		super();
	}


	public Content(Long contentId, Course course, String contentTitle, String contentDescription, String contentType,
			String contentData, String contentURL, Integer contentDuration, String contentStatus,
			Integer sequenceOrder) {
		super();
		this.contentId = contentId;
		this.course = course;
		this.contentTitle = contentTitle;
		this.contentDescription = contentDescription;
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


	public String getContentDescription() {
		return contentDescription;
	}


	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription;
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