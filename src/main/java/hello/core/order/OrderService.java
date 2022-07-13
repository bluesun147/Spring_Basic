package hello.core.order;

// 주문 서비스 인터페이스
// 구현체 필요
public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
