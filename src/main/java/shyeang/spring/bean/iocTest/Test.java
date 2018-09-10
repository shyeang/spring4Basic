package shyeang.spring.bean.iocTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shyeang.spring.bean.iocTest.configulation.Config;
import shyeang.spring.bean.iocTest.service.UseFunctionService;

public class Test {
    public static void main(String[] args){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);

        UseFunctionService ufs = ac.getBean(UseFunctionService.class);

        System.out.println(ufs.useFunction("frist demo"));

        ac.close();
    }
}
