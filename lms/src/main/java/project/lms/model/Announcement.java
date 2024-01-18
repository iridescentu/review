package project.lms.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "announcements")
public class Announcement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long announcementId;
	
	private String announcementText;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime announcementDate;
	
	private Boolean isImportant;

	public Announcement() {
		super();
	}

	public Announcement(Long announcementId, String announcementText, LocalDateTime announcementDate,
			Boolean isImportant) {
		super();
		this.announcementId = announcementId;
		this.announcementText = announcementText;
		this.announcementDate = announcementDate;
		this.isImportant = isImportant;
	}

	public Long getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(Long announcementId) {
		this.announcementId = announcementId;
	}

	public String getAnnouncementText() {
		return announcementText;
	}

	public void setAnnouncementText(String announcementText) {
		this.announcementText = announcementText;
	}

	public LocalDateTime getAnnouncementDate() {
		return announcementDate;
	}

	public void setAnnouncementDate(LocalDateTime announcementDate) {
		this.announcementDate = announcementDate;
	}

	public Boolean getIsImportant() {
		return isImportant;
	}

	public void setIsImportant(Boolean isImportant) {
		this.isImportant = isImportant;
	}
	
}
