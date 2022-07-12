package hello.core.member;

// MemberService 인터페이스의 구현체
public class MemberServiceImpl implements MemberService {

    // 가입하고 회원 찾으려면 멤버 리포지토리 인터페이스 필요
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member); // 구현체애서 오버라이드 한게 호출됨
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
