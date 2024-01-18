package project.lms.model;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "examCalendar")
public class ExamCalendar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long testId;
	
	private String testName;
	
	@Temporal(TemporalType.DATE)
	private Date testDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime startTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime endTime;
	
	private String location;
	
	@Temporal(TemporalType.DATE)
	private Date registrationDeadline;
	
	private Integer maxApplicants;
	
	private Integer currentApplicants;
	
	private Boolean isOnline;
	
	private String additionalInfo;
	
	private Integer price;

	public ExamCalendar() {
		super();
	}

	public ExamCalendar(Long testId, String testName, Date testDate, LocalDateTime startTime, LocalDateTime endTime,
			String location, Date registrationDeadline, Integer maxApplicants, Integer currentApplicants,
			Boolean isOnline, String additionalInfo, Integer price) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.testDate = testDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.registrationDeadline = registrationDeadline;
		this.maxApplicants = maxApplicants;
		this.currentApplicants = currentApplicants;
		this.isOnline = isOnline;
		this.additionalInfo = additionalInfo;
		this.price = price;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getRegistrationDeadline() {
		return registrationDeadline;
	}

	public void setRegistrationDeadline(Date registrationDeadline) {
		this.registrationDeadline = registrationDeadline;
	}

	public Integer getMaxApplicants() {
		return maxApplicants;
	}

	public void setMaxApplicants(Integer maxApplicants) {
		this.maxApplicants = maxApplicants;
	}

	public Integer getCurrentApplicants() {
		return currentApplicants;
	}

	public void setCurrentApplicants(Integer currentApplicants) {
		this.currentApplicants = currentApplicants;
	}

	public Boolean getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	
}
