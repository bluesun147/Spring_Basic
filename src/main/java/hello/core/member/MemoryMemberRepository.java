package hello.core.member;

import java.util.HashMap;
import java.util.Map;

// MemberRepository 구현체 3개 중 하나. 메모리에 개발 테스트 용으로 저장하는 구현체
public class MemoryMemberRepository implements MemberRepository {

    // 저장소니까 Map 있어야 함.
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
