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

    @Column(name = "contentImg")
    private String contentImg;

    @Column(name = "contentDuration")
    private Integer contentDuration;

    @Column(name = "contentStatus", length = 50)
    private boolean contentStatus;


	public Content() {
		super();
	}


	public Content(Long contentId, Course course, String contentTitle, String contentDescription, String contentImg,
			Integer contentDuration, boolean contentStatus) {
		super();
		this.contentId = contentId;
		this.course = course;
		this.contentTitle = contentTitle;
		this.contentDescription = contentDescription;
		this.contentImg = contentImg;
		this.contentDuration = contentDuration;
		this.contentStatus = contentStatus;
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


	public String getContentImg() {
		return contentImg;
	}


	public void setContentImg(String contentImg) {
		this.contentImg = contentImg;
	}


	public Integer getContentDuration() {
		return contentDuration;
	}


	public void setContentDuration(Integer contentDuration) {
		this.contentDuration = contentDuration;
	}


	public boolean isContentStatus() {
		return contentStatus;
	}


	public void setContentStatus(boolean contentStatus) {
		this.contentStatus = contentStatus;
	}
	
}