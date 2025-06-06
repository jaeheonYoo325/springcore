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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
