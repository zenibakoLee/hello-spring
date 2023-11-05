package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //  MemberService 및 MemberRepository에 대한 Spring 빈을 정의
public class SpringConfig {

    //    private DataSource dataSource;

//    @Autowired // DataSource를 SpringConfig 클래스의 생성자에 주입
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//    private EntityManager em;
//
//    @Autowired // DataSource를 SpringConfig 클래스의 생성자에 주입
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService() {
//        return new MemberService(memberRepository());
        return new MemberService(memberRepository);
    }

    //    @Bean
//    public MemberRepository memberRepository() {
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRespository(em);
//    }
//    @Bean
//    public TimeTraceApp tImeTraceAop() {
//        return new TimeTraceApp();
//    }
}
