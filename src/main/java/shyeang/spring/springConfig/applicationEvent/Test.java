package shyeang.spring.springConfig.applicationEvent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void  main(String [] args){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(EventConfig.class);

        DemoPublisher dp = ac.getBean(DemoPublisher.class);

        dp.publish("test for publish ");

        ac.close();
    }
}
