package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional // rollback after each test
class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memoryMemberRepository;

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");
        System.out.println("before 회원가입: " + memberService.findMembers().toString());
        //when
        Long saveId = memberService.join(member);
        //then
        System.out.println(memberService.findMembers().toString());
        Member foundMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(foundMember.getName());
    }

    @Test
    void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring_1");
        Member member2 = new Member();
        member2.setName("spring_1");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //then
    }
}