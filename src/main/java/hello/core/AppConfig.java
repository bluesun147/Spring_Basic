package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;


// AppConfig가 구현객체 생성.
public class AppConfig {
    // AppConfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해 주입(연결) 해준다
    public MemberService memberService() {
        // MemberService 객체 만들 때 MemoryMemberRepository 생성
        return new MemberServiceImpl(new MemoryMemberRepository()); // 생성자 주입
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy()); // 두개 주입
    }
}
