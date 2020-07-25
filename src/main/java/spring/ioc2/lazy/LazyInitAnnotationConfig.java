package spring.ioc2.lazy;

import org.springframework.context.annotation.*;
import spring.ioc2.bean.UserPwdChecker;
import spring.ioc2.bean.UserPwdConfig;

@Configuration
public class LazyInitAnnotationConfig {
    @Bean
    public UserPwdConfig newUserPwdConfig(){
        return new UserPwdConfig();
    }

    /**
     * 使用bean注解声明一个Bean
     * @return
     */
    @Lazy
    @Bean(name = "userPwdChecker")
    @Scope("singleton")
    public UserPwdChecker newParamChecker(UserPwdConfig config1){
        return new UserPwdChecker(config1);
    }
}
