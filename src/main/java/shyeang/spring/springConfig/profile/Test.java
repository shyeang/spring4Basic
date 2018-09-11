package shyeang.spring.springConfig.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String [] args){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

        ac.getEnvironment().setActiveProfiles("dev");
        ac.register(ProfileConfig.class);
        ac.refresh();

        DemoBean db = ac.getBean(DemoBean.class);

        System.out.println(db.getContent());

        ac.close();
    }
}
