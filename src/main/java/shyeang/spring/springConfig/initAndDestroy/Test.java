package shyeang.spring.springConfig.initAndDestroy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shyeang.spring.springConfig.scope.DemoPrototypeService;
import shyeang.spring.springConfig.scope.DemoSingletonService;
import shyeang.spring.springConfig.scope.ScopeConfig;

public class Test {
    public static void main(String[] args){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrePostConfig.class);
        BeanWayService bws = ac.getBean(BeanWayService.class);
        JSRWayService jws = ac.getBean(JSRWayService.class);

        bws.print();
        jws.print();

        System.out.println("acClose----");

        ac.close();
    }
}
