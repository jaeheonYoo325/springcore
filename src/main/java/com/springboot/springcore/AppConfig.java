package com.springboot.springcore;

import com.springboot.springcore.discount.DiscountPolicy;
import com.springboot.springcore.discount.FixDiscountPolicy;
import com.springboot.springcore.discount.RateDiscountPolicy;
import com.springboot.springcore.member.MemberRepository;
import com.springboot.springcore.member.MemberService;
import com.springboot.springcore.member.MemberServiceImpl;
import com.springboot.springcore.member.MemoryMemberRepository;
import com.springboot.springcore.order.OrderService;
import com.springboot.springcore.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
