package shyeang.spring.springH.wisely;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
//组合@ComponentScan元注解
@ComponentScan
public @interface  WiselyConfiguration {
    //覆盖value参数
    String[] value() default {};
}
