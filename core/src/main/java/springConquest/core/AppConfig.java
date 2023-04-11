package springConquest.core;

import springConquest.core.discount.DiscountPolicy;
import springConquest.core.discount.FixDiscountPolicy;
import springConquest.core.member.MemberRepository;
import springConquest.core.member.MemberService;
import springConquest.core.member.MemberServiceImpl;
import springConquest.core.member.MemoryMemberRepository;
import springConquest.core.order.OrderService;
import springConquest.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private static DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
