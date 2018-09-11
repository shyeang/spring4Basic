package shyeang.spring.springH.shecduledTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SheduledTaskService {
    private static final SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate =  5000)
    public void reportCurrentTime(){
        System.out.println("per 5 second execute once:" + df.format(new Date()));
    }

    @Scheduled(cron = "30 29 14 ? * *")
    public void  fixTimeExcecute(){
        System.out.println("fix time excecute per day:" + df.format(new Date()));
    }
}
