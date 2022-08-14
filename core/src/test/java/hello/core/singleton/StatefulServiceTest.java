package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA : A사용자가 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        // ThreadB : B사용자가 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);


        // ThreadA : A사용자 -> 주문 금액 조회
//        int price = statefulService1.getPrice();

        System.out.println("price = " + userAPrice);
        //-> 원래는 금액이 10000원이 나와야 되는데? 20000원이 출력됨. ,,!
        // 중간에 B사용자가 가격을 20000원으로 바꿔버렸기 때문.

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }


    static class TestConfig {

        // 이 bean 하나만 생성해서 사용하는 config
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}