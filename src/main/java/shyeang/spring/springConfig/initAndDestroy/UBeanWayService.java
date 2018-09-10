package shyeang.spring.springConfig.initAndDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UBeanWayService {
    public void init(){
        System.out.println("@Bean-init-method");
    }

    public UBeanWayService(){
        System.out.println("init-BeanWayService");
    }

    public void destroy(){
        System.out.println("@Bean-destroy-method");
    }

    public void print(){
        System.out.println("@Bean---------");
    }
}
