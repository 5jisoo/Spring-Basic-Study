package hello.hellosping.repository;

import hello.hellosping.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {

        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); //이렇게 하면 JPA가 알아서 아이디도 지정해줌
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);  //조회
        return Optional.ofNullable(member);
    }

    // 오 ,, sql 공부 해야 이해되겠는데,,,,
    // jpql = 객체 지향 쿼리
    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
    // Entity를 대상으로 Query를 날리는 것 > 이게 sql로 번역이 됨
}
