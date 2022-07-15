package hello.hellosping.service;

import hello.hellosping.aop.TimeTraceAop;
import hello.hellosping.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired // 생성자가 하나인 경우에는 생략 가능
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    // 이렇게 injection을 그냥 받으면 됨. -> Spring Data Jpa의 구현체에 그냥 구현됨.

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
    //위 로직을 호출해서 새로운 스프링 빈으로 등록하라는 표시

}
