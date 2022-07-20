package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //basePackages = "hello.core.member", // 탐색할 패키지의 시작 위치
        // 뺄 것들 지정. 수동등록이기 때문에. 실무에서는 그냥 다 함. 예제 코드 살리기 위해서.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
