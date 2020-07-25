package spring.ioc2;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.ioc2.check.UserPwdConfig;

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
        ConstructorArgumentValues.ValueHolder holder =  values.getArgumentValue(1, UserPwdConfig.class);
        ps(holder.getName());
    }

    private static void ps(String str){
        System.out.println(str);
    }

}
