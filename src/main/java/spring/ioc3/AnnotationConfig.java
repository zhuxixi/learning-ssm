package spring.ioc3;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import spring.ioc3.pwd.UserPwdChecker;
import spring.ioc3.pwd.UserPwdConfig;

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
    @Bean(name = "paramChecker")
    @Scope("singleton")
    public UserPwdChecker newParamChecker(){
        return new UserPwdChecker(new UserPwdConfig());
    }
}
