package shyeang.spring.springConfig.applicationEvent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class DemoLisener2  implements ApplicationListener<DemoEvent> {

    public void onApplicationEvent(DemoEvent de) {
        String msg = de.getMsg();
        System.out.println(" i2 have recived the message:" + msg +"which is the demoPublish publish");
    }
}
