package spring.ioc2.pwd;

/**
 * 登录服务密码校验Bean
 * @author zhuzh
 * @date 2020.07.25
 */
public class UserPwdChecker {



    public UserPwdChecker(UserPwdConfig config){

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