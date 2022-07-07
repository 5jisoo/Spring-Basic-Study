package hello.hellosping.repository;

import hello.hellosping.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
/* Assertions를 (Alt+Enter)static import로 넣어줌 */

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    /* 메서드 실행이 끝날 때 자동으로 호출되는 메서드 */
    public void afterEach(){
        repository.clearStore();
        //테스트가 끝나면 저장소를 한번씩 지움.
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();  //optional로 쌓여있어서 get으로 꺼냄
//        System.out.println("result = "+(result==member));
        /*Assertions.assertEquals(member, result);*/
        //기대하는 값: member와 실제값: result가 동일한지 확인해주는 Assertions. 다르면? 오류가 뜸
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);


    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
