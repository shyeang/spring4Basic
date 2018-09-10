package shyeang.spring.aopTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shyeang.spring.aopTest.configulation.AopConfig;
import shyeang.spring.aopTest.service.DemoAnnotationService;
import shyeang.spring.aopTest.service.DemoMethodService;

public class Test {
    public static void main(String [] args){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService da = ac.getBean(DemoAnnotationService.class);
        DemoMethodService dm = ac.getBean(DemoMethodService.class);

        da.add();
        dm.add();

        System.out.println("---ac.close");
        ac.close();
    }
}
