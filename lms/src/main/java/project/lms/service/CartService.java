// CartService.java

package project.lms.service;

import project.lms.dto.ResponseDto;
import project.lms.model.Cart;

import java.util.List;

public interface CartService {

    // memberId로 해당 회원의 카트 조회
    ResponseDto<List<Cart>> getCartByMemberId(Long memberId);

    // 카트에 새로운 course 추가
    ResponseDto<Void> addToCart(Long memberId, Long courseId, Integer quantity);

    // 카트에서 특정 course 삭제
    ResponseDto<Void> removeFromCart(Long memberId, Long courseId);

    // 카트에서 모든 course 삭제
    ResponseDto<Void> clearCart(Long memberId);

    // 카트에 있는 course 결제
    ResponseDto<Void> checkout(Long memberId, List<Long> courseIds);

}
