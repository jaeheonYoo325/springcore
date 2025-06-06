package com.springboot.springcore.order;

import com.springboot.springcore.discount.DiscountPolicy;
import com.springboot.springcore.discount.FixDiscountPolicy;
import com.springboot.springcore.discount.RateDiscountPolicy;
import com.springboot.springcore.member.Member;
import com.springboot.springcore.member.MemberRepository;
import com.springboot.springcore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy;

    // OCP 위반
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
