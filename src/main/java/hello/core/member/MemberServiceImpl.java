package hello.core.member;

// MemberService 인터페이스의 구현체
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository; // 인터페이스만 존재. 추상화에만 의존. 구체적인 것은 AppConfig에서 생성해서 넣어줌

    // MemberServiceImpl 입장에서 생성자 통해 어떤 구현 객체가 들어올 지 (주입 될 지)는 모름
    // MemberServiceImpl의 생성자 통해서 어떤 구현 객체 주입할 지는 오직 외부 (AppConfig)에서 결정 됨
    // 의존 관계 고민은 외부에 맡기고 실행에만 집중.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member); // 구현체애서 오버라이드 한게 호출됨
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
