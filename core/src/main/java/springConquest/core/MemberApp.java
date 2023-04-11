package springConquest.core;

import springConquest.core.member.Grade;
import springConquest.core.member.Member;
import springConquest.core.member.MemberService;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member= " + memberA.getName());
        System.out.println("find Member= " + findMember.getName());
    }
}
