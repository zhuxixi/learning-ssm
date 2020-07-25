package spring.ioc2.scope;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import spring.ioc2.bean.UserPwdChecker;
import spring.ioc2.bean.UserPwdConfig;

/**
 * @author zhuzh
 * @date 2020.07.25
 */
@Configuration
public class BeanScopePrototypeConfig {

    @Bean
    public UserPwdConfig newUserPwdConfig(){
        return new UserPwdConfig();
    }

    /**
     * 使用bean注解声明一个Bean
     * @return
     */
    @Bean(name = "paramChecker")
    @Scope("prototype")
    public UserPwdChecker newParamChecker(UserPwdConfig config1){
        return new UserPwdChecker(config1);
    }
}
