package hello.core.order;

public interface OrderService {

    // memberId, itemName, itemPrice를 입력하면 Order결과를 반환한다는 interface
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
