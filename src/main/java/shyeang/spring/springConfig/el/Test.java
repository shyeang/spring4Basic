package shyeang.spring.springConfig.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shyeang.spring.springConfig.scope.ScopeConfig;

public class Test {
    public static void  main(String[] args){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ELConfig.class);

        ELConfig ec = ac.getBean(ELConfig.class);
        ec.outputResources();

        ac.close();
    }
}
