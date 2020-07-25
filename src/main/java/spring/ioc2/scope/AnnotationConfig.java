package spring.ioc2.scope;


import org.springframework.context.annotation.*;
import spring.ioc2.bean.UserPwdChecker;
import spring.ioc2.bean.UserPwdConfig;

/**
 * @author zhuzh
 * @date 2020.07.25
 */
@Configuration
public class AnnotationConfig {

    @Bean
    public UserPwdConfig newUserPwdConfig(){
        return new UserPwdConfig();
    }

    /**
     * 使用bean注解声明一个Bean
     * @return
     */
    @Bean(name = "paramChecker")
    @Scope("singleton")
    public UserPwdChecker newParamChecker(UserPwdConfig config1){
        return new UserPwdChecker(config1);
    }
}
