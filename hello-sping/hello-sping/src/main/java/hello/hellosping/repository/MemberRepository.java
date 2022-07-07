package hello.hellosping.repository;

import hello.hellosping.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원이 저장소에 저장됨.
    /* Optional? null을 처리하는 방법. Optional으로 감싸서 처리함. */
    Optional<Member> findById(Long id); //id로 회원을 찾음.
    Optional<Member> findByName(String name);
    List<Member> findAll(); //지금까지 저장된 모든 회원 리스트를 반환해줌.
}
