package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

// 주문 서비스 구현체
public class OrderServiceImpl implements OrderService {

    // 회원 찾기
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 할인 정책
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

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
