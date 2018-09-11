package shyeang.spring.springConfig.applicationEvent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoLisener implements ApplicationListener<DemoEvent> {

    public void onApplicationEvent(DemoEvent de) {
        String msg = de.getMsg();
        System.out.println(" i have recived the message:" + msg +"which is the demoPublish publish");
    }

}
