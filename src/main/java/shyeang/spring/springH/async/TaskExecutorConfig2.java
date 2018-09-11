package shyeang.spring.springH.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@ComponentScan("shyeang.spring.springH.async")
@EnableAsync
public class TaskExecutorConfig2 implements AsyncConfigurer {
    public static int i = 0;
    public static String  name = "a";
    @Nullable
    @Override
    public ThreadPoolTaskExecutor getAsyncExecutor() {
        //Exception in thread "main" org.springframework.core.task.TaskRejectedException:
        // Executor [java.util.concurrent.ThreadPoolExecutor@7722c3c3[Running, pool size = 60, active threads = 28, queued tasks = 40, completed tasks = 454]]
        ThreadPoolTaskExecutor te = new ThreadPoolTaskExecutor();
        te.setCorePoolSize(10);
        te.setMaxPoolSize(60);
        te.setQueueCapacity(40);
        te.setThreadNamePrefix(name + String .valueOf(i++));
        te.initialize();
        name = "b";

        System.out.println("active count:" + te.getActiveCount() );
        return te;
    }

    @Nullable
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}