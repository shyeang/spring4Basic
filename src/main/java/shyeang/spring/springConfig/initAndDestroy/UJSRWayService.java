package shyeang.spring.springConfig.initAndDestroy;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class UJSRWayService {
    @PostConstruct
    public void init(){
        System.out.println("@JSRWayService-init-method");
    }

    public UJSRWayService(){
        System.out.println("init-JSRWayService");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("@JSRWayService-destroy-method");
    }

    public void print(){
        System.out.println("@JSRWayService---------");
    }
}
