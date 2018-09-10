package shyeang.spring.springConfig.initAndDestroy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSRWayService {
    @PostConstruct
    public void init(){
        System.out.println("@JSRWayService-init-method");
    }

    public JSRWayService(){
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
