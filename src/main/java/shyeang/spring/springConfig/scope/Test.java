package shyeang.spring.springConfig.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ScopeConfig.class);
        DemoPrototypeService dps1 = ac.getBean(DemoPrototypeService.class);
        DemoPrototypeService dps2 = ac.getBean(DemoPrototypeService.class);
        DemoSingletonService dss1 = ac.getBean(DemoSingletonService.class);
        DemoSingletonService dss2 = ac.getBean(DemoSingletonService.class);

        System.out.println("dps判断：" + (dps1 == dps2));
        System.out.println("dss判断：" + (dss1 == dss2));
    }
}
