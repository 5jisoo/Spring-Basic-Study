package hello.hellosping.service;

import hello.hellosping.domain.Member;
import hello.hellosping.repository.MemberRepository;
import hello.hellosping.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    // @Autowired 로 편하게 연결!


    @Test
    void 회원가입() {
        //한글로도 많이 적음!
        //given - 무언가 주어졌을 때
        Member member = new Member();
        member.setName("spring");

        //when - 이것을 실행했을 때
        Long saveId = memberService.join(member);

        //then - 나와야되는 결과
        //saveId로 찾은 Member객체를 findMember에 넣어줌
        Member findMember = memberRepository.findById(saveId).get();

        //findMember의 이름과 member의 이름이 같은지 비교해줌
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    }
}