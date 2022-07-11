package hello.hellosping.service;

import hello.hellosping.repository.MemberRepository;
import hello.hellosping.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    //위 로직을 호출해서 새로운 스프링 빈으로 등록하라는 표시

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
