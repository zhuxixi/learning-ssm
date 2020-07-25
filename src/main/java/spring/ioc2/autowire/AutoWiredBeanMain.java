package spring.ioc2.autowire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.common.CommonUtil;

/**
 * @author zhuzhenxi
 * @date 2020.07.25
 */
public class AutoWiredBeanMain {
    public static void main(String[] args){
        AnnotationConfigApplicationContext autoWiredIoc = new AnnotationConfigApplicationContext(AutoWiredBeanConfig.class);
        UserPwdChecker checker1 = autoWiredIoc.getBean(UserPwdChecker.class);
        UserPwdChecker checker2 = autoWiredIoc.getBean(UserPwdChecker.class);
        CommonUtil.ps("Bean Scope为Singleton时:checker1 和 checker2 指向同一地址？"+(checker1==checker2));
        autoWiredIoc.close();

    }



}
