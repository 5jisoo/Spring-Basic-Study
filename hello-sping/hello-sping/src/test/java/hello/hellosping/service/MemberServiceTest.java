package hello.hellosping.service;

import hello.hellosping.domain.Member;
import hello.hellosping.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
         memberService = new MemberService(memberRepository);
        //이렇게 해야 memberService가 같은 memberRepository를 사용하게 됨
    }

    @AfterEach
    /* 메서드 실행이 끝날 때 자동으로 호출되는 메서드 */
    public void afterEach(){
        memberRepository.clearStore();
        //테스트가 끝나면 저장소를 한번씩 지움.
    }

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
        Member findMember = memberService.findOne(saveId).get();

        //findMember의 이름과 member의 이름이 같은지 비교해줌
        assertThat(member.getName()).isEqualTo(findMember.getName());
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
/*
        try{
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
*/

        //then
    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {

    }
}