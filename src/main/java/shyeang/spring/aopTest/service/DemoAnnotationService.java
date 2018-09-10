package shyeang.spring.aopTest.service;

import org.springframework.stereotype.Service;
import shyeang.spring.aopTest.action.Action;

@Service
public class DemoAnnotationService {
    @Action(name="注解式拦截的add操作")
    public void add(){System.out.println("add");}
}
