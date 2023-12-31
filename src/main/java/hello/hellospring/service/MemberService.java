package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional // JPA 사용시 서비스 계층에 필수
public class MemberService {
    private final MemberRepository memberRepository;

    //    @Autowired // memberRepository Dependency Injection
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; // Dependency Injection
    }

    /*
        회원가입
         */
    public Long join(Member member) {
        validateDuplicatedMember(member); // ctrl+t & extract method
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicatedMember(Member member) {
//        Optional<Member> result = memberRepository.findByName(member.getName()); // cmd+opt+v optional null handle
//        result.ifPresent(m->{
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
