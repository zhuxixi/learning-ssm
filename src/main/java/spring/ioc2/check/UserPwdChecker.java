package spring.ioc2.check;

import jdk.nashorn.internal.objects.annotations.Constructor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.beans.ConstructorProperties;

/**
 * 登录服务密码校验Bean
 * @author zhuzh
 * @date 2020.07.25
 */
public class UserPwdChecker {

    private UserPwdConfig config ;
    public UserPwdChecker(UserPwdConfig config1){
      config = config1;
    }

    @PostConstruct
    public void init(){
       if (config.isLocalCacheOn()){
           System.out.println("UserPwdChecker local cache on");
       }
       if (config.isSaleNoNumberCheckOn()){
           System.out.println("UserPwdChecker 开启了工号数字检查");
       }
    }

    @PreDestroy
    public void destroy(){
        System.out.println("cleaning cache");
    }

    /**
     * check password that user entered right or not
     * @param password
     * @return
     */
    public boolean pwdMatch(String password,String expectValue){
        if (password==null){
            throw new IllegalArgumentException("password could not be empty!");
        }

        if (expectValue==null){
            throw new IllegalArgumentException("the real password could not be empty!");
        }

        return password.equals(expectValue);
    }
}
