package spring.junit.testcase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import spring.common.CommonUtil;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 登录服务密码校验Bean
 * @author zhuzh
 * @date 2020.07.25
 */
@Component
@Scope("prototype")
public class UserPwdChecker {

    @Autowired
    private UserPwdConfig config ;

    @PostConstruct
    public void init(){
        CommonUtil.ps("正在初始化Bean,执行init方法...");
       if (config.isLocalCacheOn()){
           System.out.println("UserPwdChecker local cache on");
       }
       if (config.isSaleNoNumberCheckOn()){
           System.out.println("UserPwdChecker 开启了工号数字检查");
       }
        CommonUtil.ps("初始化Bean结束,init方法执行结束...");

    }

    @PreDestroy
    public void destroy(){
        CommonUtil.ps("正在销毁Bean，执行清理方法");
        CommonUtil.ps("缓存清理完毕");
        CommonUtil.ps("Bean销毁结束，清理方法执行完毕");
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

    public UserPwdConfig getConfig() {
        return config;
    }

    public void setConfig(UserPwdConfig config) {
        this.config = config;
    }
}
