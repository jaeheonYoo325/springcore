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

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()

    // 예상 호출
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // call AppConfig.memberRepository

    // 결과 호출
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // 이미 스프링 컨테이너에 빈이 등록 되어 있으면, 스프링 컨테이너에서 찾아서 반환
    // 스프링 컨테이너에 빈이 등록되어 있는게 없으면, 기존 로직 호출해서 빈을 생성하고 스프링 컨테이너에 등록

    // @Configuration 지정안하면 예상호출처럼 호출되고 싱글톤 깨짐

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
