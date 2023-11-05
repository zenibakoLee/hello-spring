package hello.hellospring;

import hello.hellospring.repository.JpaMemberRespository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //  MemberService 및 MemberRepository에 대한 Spring 빈을 정의
public class SpringConfig {

    //    private DataSource dataSource;
//

//    @Autowired // DataSource를 SpringConfig 클래스의 생성자에 주입
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    private EntityManager em;

    @Autowired // DataSource를 SpringConfig 클래스의 생성자에 주입
    public SpringConfig(EntityManager em) {
        this.em = em;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRespository(em);
    }
}
