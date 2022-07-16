package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// AppConfig가 구현객체 생성.
@Configuration
public class AppConfig {
    // AppConfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해 주입(연결) 해준다

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() { // 역할 다 드러남.
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        // MemberService 객체 만들 때 MemoryMemberRepository 생성
        return new MemberServiceImpl(memberRepository()); // 생성자 주입.
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy()); // 두개 주입
    }
}