package com.springboot.springcore;

import com.springboot.springcore.member.MemberRepository;
import com.springboot.springcore.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // 수동 Bean 설정
    // 수동 Bean 등록 vs 자동 Bean 등록, 충돌
    // @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
