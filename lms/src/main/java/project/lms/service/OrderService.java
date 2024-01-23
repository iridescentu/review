package project.lms.service;

import project.lms.dto.ResponseDto;
import project.lms.model.Order;

import java.util.List;

public interface OrderService {

    // 회원별 주문 목록 조회
    ResponseDto<List<Order>> getOrdersByMemberId(Long memberId);

    // 카트에서 선택한 상품 결제 처리
    ResponseDto<Void> placeOrder(Long memberId, List<Long> courseIds);

    // 주문 정보 생성
    Order createOrderFromCartItems(Long memberId, List<Long> courseIds);
}
