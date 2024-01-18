package project.lms.dto;

import project.lms.model.Course;

public class CourseDto {

	private Long courseId;
    private Long subjectId;
    private String courseName;
    private String description;
    private byte[] courseThumbnail;
    private String contentLevel;
    private Integer durationMins;
    private Integer price;
    
	public CourseDto() {
		super();
	}

	public CourseDto(Long courseId, Long subjectId, String courseName, String description, byte[] courseThumbnail,
			String contentLevel, Integer durationMins, Integer price) {
		super();
		this.courseId = courseId;
		this.subjectId = subjectId;
		this.courseName = courseName;
		this.description = description;
		this.courseThumbnail = courseThumbnail;
		this.contentLevel = contentLevel;
		this.durationMins = durationMins;
		this.price = price;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getCourseThumbnail() {
		return courseThumbnail;
	}

	public void setCourseThumbnail(byte[] courseThumbnail) {
		this.courseThumbnail = courseThumbnail;
	}

	public String getContentLevel() {
		return contentLevel;
	}

	public void setContentLevel(String contentLevel) {
		this.contentLevel = contentLevel;
	}

	public Integer getDurationMins() {
		return durationMins;
	}

	public void setDurationMins(Integer durationMins) {
		this.durationMins = durationMins;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public static CourseDto fromEntity(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseId(course.getCourseId());
        courseDto.setSubjectId(course.getSubject().getSubjectId());
        courseDto.setCourseName(course.getCourseName());
        courseDto.setDescription(course.getDescription());
        courseDto.setCourseThumbnail(course.getCourseThumbnail());
        courseDto.setContentLevel(course.getContentLevel());
        courseDto.setDurationMins(course.getDurationMins());
        courseDto.setPrice(course.getPrice());
        return courseDto;
    }
    
}
