package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{
    
    // 2. 주입된 memberRepository 넣어짐
    private final MemberRepository memberRepository;
    
    // 1. AppConfig 실행 시 MemberServiceImpl 생성자를 통해 memberRepository가 주입이 됌
    @Autowired  // ac.getBean(MemberSRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
