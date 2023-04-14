package springConquest.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springConquest.core.discount.DiscountPolicy;
import springConquest.core.discount.FixDiscountPolicy;
import springConquest.core.discount.RateDiscountPolicy;
import springConquest.core.member.MemberRepository;
import springConquest.core.member.MemberService;
import springConquest.core.member.MemberServiceImpl;
import springConquest.core.member.MemoryMemberRepository;
import springConquest.core.order.OrderService;
import springConquest.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
