package shyeang.spring.springConfig.applicationEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoPublisher {
    @Autowired
    ApplicationContext applicationContext;

    public void  publish(String  msg){
        System.out.println("start publish----");
        applicationContext.publishEvent(new DemoEvent(this, msg));
        System.out.println("end publish----");
    }
}
