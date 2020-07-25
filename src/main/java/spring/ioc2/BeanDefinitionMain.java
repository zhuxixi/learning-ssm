package spring.ioc2;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhuzhenxi
 * @date 2020.07.25
 */
public class BeanDefinitionMain {
    public static void main(String[] args){
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        BeanDefinition definition = container.getBeanDefinition("paramChecker");
        System.out.println(definition.getScope());
    }
}
