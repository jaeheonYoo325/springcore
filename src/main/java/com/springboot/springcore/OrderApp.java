package com.springboot.springcore;

import com.springboot.springcore.member.Grade;
import com.springboot.springcore.member.Member;
import com.springboot.springcore.member.MemberService;
import com.springboot.springcore.member.MemberServiceImpl;
import com.springboot.springcore.order.Order;
import com.springboot.springcore.order.OrderService;
import com.springboot.springcore.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
