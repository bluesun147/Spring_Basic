package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

// 주문 서비스 구현체
public class OrderServiceImpl implements OrderService {

    // 회원 찾기
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 할인 정책
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 구현체에도 의존하고 있음!! dip 위반
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 이 코드로 바꾸면 ocp 위반

    // ==> 이 문제 어떻게 해결할까?
    // 누군가가 클라이언트(OrderServiceImpl)에 DiscountPolicy의 구현 객체 대신 생성하고 주입해줘야 함.

    private DiscountPolicy discountPolicy; // 추상화(인터페이스)에만 의존

    // 주문 생성 요청 오면 회원 정보 조회 하고, 할인 정책에 회원 넘김
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // 설계 잘 됨. 오더 서비스 입장에선 할인에 대해선 모름. 할인에 대한 것은 discountPolicy가 알아서 하고 결과만 던져줌.
        // -> 단일 체계 원칙 잘 지킴
        int discountPrice = discountPolicy.discount(member, itemPrice);

        // 최종 생성 주문 반환
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
