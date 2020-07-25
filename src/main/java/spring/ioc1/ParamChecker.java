package spring.ioc1;

import org.springframework.stereotype.Component;

@Component
public class ParamChecker {

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
