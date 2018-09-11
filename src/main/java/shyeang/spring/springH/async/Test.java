package shyeang.spring.springH.async;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import shyeang.spring.springH.springAware.AwareConfig;
import shyeang.spring.springH.springAware.AwareService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class Test {
    public static void main(String [] args) throws InterruptedException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        executeAsyncTask ea = ac.getBean(executeAsyncTask.class);
        List<Integer> li = new ArrayList<Integer>();
        //
        for (int i = 0; i < 1000; i++){
            try {
                //executeAsynTask与executeAsyncTaskPlus存在由两个线程分别执行的情况
                //3----a----getAsyncExecutor-7
                //3----b----getAsyncExecutor-8
                ea.executeAsynTask(i);
                ea.executeAsyncTaskPlus(i);
//                System.out.println("a----" + i );
            } catch (TaskRejectedException te){
                li.add(i);
            }
//            ea.executeAsyncTaskPlus(i);
        }


        Thread.sleep(10000);
        System.out.println("==================" );
        for (Integer i:li){
            System.out.println("--aaa--" + i );
        }

//
//        for (int i = 0; i < 10; i++){
////            ea.executeAsynTask(i);
//            ea.executeAsyncTaskPlus(i);
//        }

        ac.close();
    }
}
