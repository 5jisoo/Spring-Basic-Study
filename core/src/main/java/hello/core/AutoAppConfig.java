package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// AppConfig 여기도 @Configuration 애노테이션이 붙어있기 때문에, 자동 스캔 대상임.
// 예제 코드들을 살리기 위해서 @Configuration이 붙었던 예제 코드들이 스캔되지 않도록 ComponentScan.Filter를 통해 걸러내줌!
@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
                classes = Configuration.class)
)
public class AutoAppConfig {

}
