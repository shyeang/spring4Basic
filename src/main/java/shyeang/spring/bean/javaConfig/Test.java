package shyeang.spring.bean.javaConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shyeang.spring.bean.javaConfig.configulation.JavaConfig;
import shyeang.spring.bean.javaConfig.service.UseFunctionService;

public class Test {
    public static void main(String[] args){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);

        UseFunctionService ufs = ac.getBean(UseFunctionService.class);

        System.out.println(ufs.useFunction("java frist demo"));

        ac.close();
    }
}
