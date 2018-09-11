package shyeang.spring.springH.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class executeAsyncTask {
    public List<String > ls = new ArrayList<>();
    public int count = 0;

    @Async
    public void executeAsynTask(Integer i) throws InterruptedException {
        System.out.println(i + "----a----" + Thread.currentThread().getName());
    }

    @Async
    public void  executeAsyncTaskPlus(Integer i) throws InterruptedException {
        System.out.println(i + "----b----" + Thread.currentThread().getName());
    }
}
