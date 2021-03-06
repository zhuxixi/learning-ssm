package spring.ioc1;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhuzh
 * @date 2020.07.25
 */
@Configuration
@ComponentScan("spring.ioc1")
public class AnnotationConfig {

    /**
     * 使用bean注解声明一个Bean
     * @return
     */
    @Bean
    public ParamChecker newParamChecker(){
        return new ParamChecker();
    }
}
