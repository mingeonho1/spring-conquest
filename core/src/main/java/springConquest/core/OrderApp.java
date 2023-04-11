package springConquest.core;

import springConquest.core.member.Grade;
import springConquest.core.member.Member;
import springConquest.core.member.MemberService;
import springConquest.core.order.Order;
import springConquest.core.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order= " + order);
        System.out.println("order.calculatePrice= " + order.calculatePrice());

    }

}
