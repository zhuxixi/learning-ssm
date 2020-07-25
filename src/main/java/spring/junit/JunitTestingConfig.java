package spring.junit;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author zhuzh
 * @date 2020.07.25
 */
@Configuration
@ComponentScan("spring.junit.testcase")
public class JunitTestingConfig {

}
