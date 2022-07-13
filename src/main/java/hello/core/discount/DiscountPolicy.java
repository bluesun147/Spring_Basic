package hello.core.discount;

import hello.core.member.Member;

// 할인 정책
// 구현체 만들어야 함 (정액 할인 정책, )
public interface DiscountPolicy {
    // return 할인 대상 금액
    int discount(Member member, int price);
}
