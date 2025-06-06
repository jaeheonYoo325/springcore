package com.springboot.springcore;

import com.springboot.springcore.discount.FixDiscountPolicy;
import com.springboot.springcore.member.MemberService;
import com.springboot.springcore.member.MemberServiceImpl;
import com.springboot.springcore.member.MemoryMemberRepository;
import com.springboot.springcore.order.OrderService;
import com.springboot.springcore.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
