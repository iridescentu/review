package project.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.lms.model.Member;
import project.lms.model.Notification;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // 특정 회원의 알림을 조회하는 메서드
    List<Notification> findByMember(Member member);

    // 읽지 않은 알림을 조회하는 메서드
    List<Notification> findByMemberAndIsRead(Member member, Boolean isRead);
    
    // 특정 타입의 알림을 조회하는 메서드
    List<Notification> findByMemberAndNotificationType(Member member, String notificationType);

    // 특정 타입의 읽지 않은 알림을 조회하는 메서드
    List<Notification> findByMemberAndNotificationTypeAndIsRead(Member member, String notificationType, Boolean isRead);

}
