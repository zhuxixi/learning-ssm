package spring.ioc2.lazy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.common.CommonUtil;

public class LazyInitMain {
    public static void main(String[] args){
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(LazyInitAnnotationConfig.class);
        CommonUtil.ps("懒加载容器已经初始化,但是Bean并没有初始化");
        CommonUtil.ps("准备getBean,此时才会初始化");
        container.getBean("userPwdChecker");

        container.close();
    }
}
