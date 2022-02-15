package hello.core.member;

public class MemberServiceImpl implements MemberService{
    
    // 2. 주입된 memberRepository 넣어짐
    private final MemberRepository memberRepository;
    
    // 1. AppConfig 실행 시 MemberServiceImpl 생성자를 통해 memberRepository가 주입이 됌  
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
}
