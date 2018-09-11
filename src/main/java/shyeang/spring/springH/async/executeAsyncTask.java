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
//        synchronized (this){
//            while(count == 0){
//                this.wait();
//            }
//            ls.add("execute async task:" + i);
//            count--;
//        }

    }

    @Async
    public void  executeAsyncTaskPlus(Integer i) throws InterruptedException {
        System.out.println("----b----" + Thread.currentThread().getName());
//        synchronized (this){
//            while (count > 20){
//                this.wait();
//            }
//            count++;
//            ls.add("execute async task plus:" + i);
//            this.notifyAll();
//        }
    }
}
