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
@Table(name = "withdrawal")
public class Withdrawal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long withdrawalID; // 탈퇴 ID는 int 형태로 사용합니다.

    @ManyToOne
    @JoinColumn(name = "memberID", nullable = false)
    private Member memberID; // 고유한 회원 ID

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime withdrawalTime; // 탈퇴 날짜와 시간

    @Column(length = 255) // varchar의 기본 길이는 255 자. 그리고 특별한 길이 제한이 없는 경우에는 생략 가능.
    private String reason; // 탈퇴 사유

    // 기본 생성자
    public Withdrawal() {
        super();
    }

    // 전체 생성자
	public Withdrawal(Long withdrawalID, Member memberID, LocalDateTime withdrawalTime, String reason) {
		super();
		this.withdrawalID = withdrawalID;
		this.memberID = memberID;
		this.withdrawalTime = withdrawalTime;
		this.reason = reason;
	}

    // Getters and Setters
	public Long getWithdrawalID() {
		return withdrawalID;
	}

	public void setWithdrawalID(Long withdrawalID) {
		this.withdrawalID = withdrawalID;
	}

	public Member getMemberID() {
		return memberID;
	}

	public void setMemberID(Member memberID) {
		this.memberID = memberID;
	}

	public LocalDateTime getWithdrawalTime() {
		return withdrawalTime;
	}

	public void setWithdrawalTime(LocalDateTime withdrawalTime) {
		this.withdrawalTime = withdrawalTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
    
}