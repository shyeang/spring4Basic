package shyeang.spring.aopTest.configulation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("shyeang.spring.aopTest")
@EnableAspectJAutoProxy
public class AopConfig {
}
