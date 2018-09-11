package shyeang.spring.springH.wisely;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shyeang.spring.springH.springAware.AwareConfig;
import shyeang.spring.springH.springAware.AwareService;

public class Test {
    public static void main(String [] args){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(WiselyConfig.class);
        WiselyService as = ac.getBean(WiselyService.class);

        as.output();

        ac.close();
    }
}
