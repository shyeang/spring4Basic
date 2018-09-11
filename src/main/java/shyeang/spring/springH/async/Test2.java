package shyeang.spring.springH.async;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
    public static void main(String [] args) throws InterruptedException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        executeAsyncTask ea = ac.getBean(executeAsyncTask.class);

        for (int i = 0; i < 10; i++){
            ea.executeAsynTask(i);
//            ea.executeAsyncTaskPlus(i);
        }

        ac.close();
    }
}
