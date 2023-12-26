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

@Entity
@Table(name = "loginHistory")
public class LoginHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logID;

    @ManyToOne
    @JoinColumn(name = "memberID", nullable = false)
    private Member memberID;

    @Column(nullable = false)
    private LocalDateTime loginTime;

    @Column(nullable = false, length = 50)
    private String ipAddress;

    // 기본 생성자
    public LoginHistory() {
        super();
    }

    // 전체 생성자
	public LoginHistory(Long logID, Member memberID, LocalDateTime loginTime, String ipAddress) {
		super();
		this.logID = logID;
		this.memberID = memberID;
		this.loginTime = loginTime;
		this.ipAddress = ipAddress;
	}
	
    // Getters and Setters
	public Long getLogID() {
		return logID;
	}

	public void setLogID(Long logID) {
		this.logID = logID;
	}

	public Member getMemberID() {
		return memberID;
	}

	public void setMemberID(Member memberID) {
		this.memberID = memberID;
	}

	public LocalDateTime getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(LocalDateTime loginTime) {
		this.loginTime = loginTime;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
    
}