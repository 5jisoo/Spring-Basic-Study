package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 가입을하고, 회원을 찾기 위해서 멤버리포지토리 인터페이스가 필요함.
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
