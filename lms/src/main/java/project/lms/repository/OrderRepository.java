package project.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.lms.enumstatus.OrderStatus;
import project.lms.enumstatus.PaymentStatus;
import project.lms.model.Member;
import project.lms.model.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // 특정 회원의 모든 주문 조회
    List<Order> findByMember(Member member);

    // 주문 상태에 따라 조회
    List<Order> findByOrderStatus(OrderStatus orderStatus);

    // 특정 날짜 범위 내의 주문 조회
    List<Order> findByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // 주문 상태와 날짜 범위를 조합하여 조회
    List<Order> findByOrderStatusAndOrderDateBetween(OrderStatus orderStatus, LocalDateTime startDate, LocalDateTime endDate);

    // 특정 회원의 주문 중 결제 완료된 주문 조회
    List<Order> findByMemberAndPaymentStatus(Member member, PaymentStatus paymentStatus);

}
