package shyeang.spring.springConfig.initAndDestroy;

public class BeanWayService {
    public void init(){
        System.out.println("@Bean-init-method");
    }

    public BeanWayService(){
        System.out.println("init-BeanWayService");
    }

    public void destroy(){
        System.out.println("@Bean-destroy-method");
    }

    public void print(){
        System.out.println("@Bean---------");
    }
}
