package study.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QuerydslApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuerydslApplication.class, args);
    }


    //동시성 문제 없음 -> EntityManager는 스프링에서 가짜 Proxy 객체를 넣어줌 -> 트랜잭션단위로 다른데 바인딩되도록 바인딩해줌 -> 책 13.1 참고
    @Bean
    JPAQueryFactory jpaQueryFactory(EntityManager em) {
        return new JPAQueryFactory(em);
    }
}
