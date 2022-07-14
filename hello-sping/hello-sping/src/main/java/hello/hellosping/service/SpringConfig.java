package hello.hellosping.service;

import hello.hellosping.repository.JdbcTemplateMemberRepository;
import hello.hellosping.repository.MemberRepository;
import hello.hellosping.repository.MemoryMemberRepository;
import hello.hellosping.repository.jdbcMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    //위 로직을 호출해서 새로운 스프링 빈으로 등록하라는 표시

    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new jdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
    // 다른 어떤 코드도 변환하지 않고 springConfig 코드만 변환함으로써 DB 연결을 바꿈.
}
