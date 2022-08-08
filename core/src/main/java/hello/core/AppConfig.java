package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //메서드명을 보는 순간 역할을 다 알게 만들어라

    //memberService 역할
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    //memberRepository 역할
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    //orderService 역할
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //discountPolicy 역할
    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
