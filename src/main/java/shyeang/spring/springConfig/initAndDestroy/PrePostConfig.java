package shyeang.spring.springConfig.initAndDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("shyeang.spring.springConfig.initAndDestroy")
public class PrePostConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    BeanWayService beanWayService(){
        return new BeanWayService();
    }

    @Bean
    JSRWayService jSRWayService(){
        return  new JSRWayService();
    }
}
