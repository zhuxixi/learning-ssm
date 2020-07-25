package spring.ioc1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhuzhenxi
 * @date 2020.07.25
 */
public class IntroduceIocContainer {
    public static void main(String[] args){
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        ParamChecker a =  container.getBean(ParamChecker.class);
        String password = "Clic1234";
        String expectValue = "Clic1234!";
        System.out.println(a.pwdMatch(password,expectValue));
    }
}
