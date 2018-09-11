package shyeang.spring.springH.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shyeang.spring.springH.shecduledTask.SheduledTaskConfig;

public class Test {
    public static void main(String [] args) throws InterruptedException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService ls = ac.getBean(ListService.class);

        System.out.println(ListService.class);

        System.out.println(ls.showListCmd());

    }}
