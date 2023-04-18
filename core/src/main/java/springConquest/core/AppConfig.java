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

    // @Bean MemberService -> new MemoryMemberRepository()
    // @Bean OrderService -> new MemoryMemberRepository()

    /* 예상하는 프린트문 */
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // call AppConfig.memberRepository
    
    /* 프린트된 결과 */
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.orderService

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
