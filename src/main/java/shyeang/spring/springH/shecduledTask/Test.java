package shyeang.spring.springH.shecduledTask;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String [] args) throws InterruptedException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SheduledTaskConfig.class);

    }
}