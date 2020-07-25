package spring.ioc2.scope;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.ioc2.bean.UserPwdChecker;
import spring.ioc2.bean.UserPwdConfig;

/**
 * @author zhuzhenxi
 * @date 2020.07.25
 */
public class BeanDefinitionMain {
    public static void main(String[] args){
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        BeanDefinition definition = container.getBeanDefinition("paramChecker");

        printBeanName(definition);
        printBeanScope(definition);
        printInitMethod(definition);

        container.getBean(UserPwdChecker.class);
        printBeanName(definition);
        printBeanScope(definition);
//        printConstructorArgs(definition);
        printInitMethod(definition);
        container.close();

    }

    private static void printBeanName(BeanDefinition definition){
        ps("Bean Class Name is "+definition.getBeanClassName());
    }

    private static void printBeanScope(BeanDefinition definition){
        String msg = definition.isSingleton()?"singleton":"not singleton";
        ps("Bean Scope is "+msg);
    }

    private static void printConstructorArgs(BeanDefinition definition){
        ConstructorArgumentValues values = definition.getConstructorArgumentValues();
        ConstructorArgumentValues.ValueHolder holder =  values.getArgumentValue(0, UserPwdConfig.class);
        ps(holder.getName());
    }

    private static void printInitMethod(BeanDefinition definition){
        ps(definition.getScope());
    }
    private static void ps(String str){
        System.out.println(str);
    }

}
