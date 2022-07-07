package hello.hellosping.repository;

import hello.hellosping.domain.Member;

import java.util.*;

/*
* 동시성 문제가 고려되어 있지 않음. 실무에서는 ConcurrentHashMap, AtomicLong 사용을 고려.
* */
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //key 값을 생성해줌.

    @Override
    public Member save(Member member) {
       member.setId(++sequence); //id를 세팅해줌
       store.put(member.getId(), member); //store에 저장해줌
       return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        //store.get(id)가 null 일 경우를 생각해서 Optional.ofNullable에 감쌈
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        //이건 자바 문법을 좀 봐야할듯
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
        /* store를 비우는 용도 */
    }
}
