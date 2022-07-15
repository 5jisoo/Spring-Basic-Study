package hello.hellosping.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class TimeTraceAop {
    @Around("execution(* hello.hellosping..*(..))") //실행할때 패키지 명, 클래스 명, 파라미터 타입 등등을 설정할 수 있음.
    // 여기서는 hello.hellospring에는 전부 적용하라는 뜻
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString()+ " " + timeMs + "ms");
        }
    }
}
