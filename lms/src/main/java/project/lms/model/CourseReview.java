package project.lms.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "courseReviews")
public class CourseReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewID;

    @ManyToOne // ManyToOne 관계 설정: 하나의 리뷰는 하나의 회원 ID를 가질 수 있음
    @JoinColumn(name = "memberID", nullable = false)
    private Member memberID;

    @ManyToOne // ManyToOne 관계 설정: 하나의 리뷰는 하나의 강의 ID를 가질 수 있음
    @JoinColumn(name = "courseID", nullable = false)
    private Course courseID;

    @Column(nullable = false)
    private Integer rating;

    @Column(nullable = true, length = 2000) // 리뷰 내용은 필수가 아닐 수 있음
    private String comment;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime reviewDate;

    // 기본 생성자
    public CourseReview() {
        super();
    }

    // 전체 생성자
	public CourseReview(Long reviewID, Member memberID, Course courseID, Integer rating, String comment,
			LocalDateTime reviewDate) {
		super();
		this.reviewID = reviewID;
		this.memberID = memberID;
		this.courseID = courseID;
		this.rating = rating;
		this.comment = comment;
		this.reviewDate = reviewDate;
	}

    // Getters and Setters
	public Long getReviewID() {
		return reviewID;
	}

	public void setReviewID(Long reviewID) {
		this.reviewID = reviewID;
	}

	public Member getMemberID() {
		return memberID;
	}

	public void setMemberID(Member memberID) {
		this.memberID = memberID;
	}

	public Course getCourseID() {
		return courseID;
	}

	public void setCourseID(Course courseID) {
		this.courseID = courseID;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(LocalDateTime reviewDate) {
		this.reviewDate = reviewDate;
	}	
   
}