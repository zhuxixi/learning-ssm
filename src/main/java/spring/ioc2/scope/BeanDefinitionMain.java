package spring.ioc2.scope;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.common.CommonUtil;
import spring.ioc2.bean.UserPwdChecker;

/**
 * @author zhuzhenxi
 * @date 2020.07.25
 */
public class BeanDefinitionMain {
    public static void main(String[] args){
        AnnotationConfigApplicationContext singletonIoc = new AnnotationConfigApplicationContext(BeanScopeSingletonConfig.class);
        UserPwdChecker checker1 = singletonIoc.getBean(UserPwdChecker.class);
        UserPwdChecker checker2 = singletonIoc.getBean(UserPwdChecker.class);
        CommonUtil.ps("Bean Scope为Singleton时:checker1 和 checker2 指向同一地址？"+(checker1==checker2));
        singletonIoc.close();


        AnnotationConfigApplicationContext protoTypeIoc = new AnnotationConfigApplicationContext(BeanScopePrototypeConfig.class);
        UserPwdChecker checker3 = protoTypeIoc.getBean(UserPwdChecker.class);
        UserPwdChecker checker4 = protoTypeIoc.getBean(UserPwdChecker.class);
        CommonUtil.ps("Bean Scope为Prototype时:checker3 和 checker4 指向同一地址？"+(checker3==checker4));
        protoTypeIoc.close();
    }



}
