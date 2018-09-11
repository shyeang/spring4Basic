package shyeang.spring.springH.springAware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shyeang.spring.springConfig.scope.ScopeConfig;

public class Test {
    public static void main(String [] args){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService as = ac.getBean(AwareService.class);

        as.outputResult();

        ac.close();
    }
}
