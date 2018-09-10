package shyeang.spring.aopTest.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import shyeang.spring.aopTest.action.Action;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(shyeang.spring.aopTest.action.Action)")
    public void annotationPointCut(){    }

    @After("annotationPointCut()")
    public void  after1(JoinPoint jp){
        MethodSignature ms = (MethodSignature)jp.getSignature();

        Method m = ms.getMethod();
        Action a = m.getAnnotation(Action.class);
        System.out.println("after注解式拦截"+ a.name());
    }


    @Before("annotationPointCut()")
    public void  before1(JoinPoint jp){
        MethodSignature ms = (MethodSignature)jp.getSignature();

        Method m = ms.getMethod();
        Action a = m.getAnnotation(Action.class);
        System.out.println("before注解式拦截"+ a.name());
    }


    @Around("annotationPointCut()")
    public void  around1(ProceedingJoinPoint jp) throws Throwable {
        MethodSignature ms = (MethodSignature)jp.getSignature();

        Method m = ms.getMethod();
        Action a = m.getAnnotation(Action.class);
        System.out.println("Around1注解式拦截"+ a.name());
        jp.proceed();
        System.out.println("Around2注解式拦截"+ a.name());
    }

//    @Before(value = "execution(*shyeang.spring.aopTest.service.DemoMethodService.*(..))")
//    public void befor1(JoinPoint jp){
//        MethodSignature ms = (MethodSignature)jp.getSignature();
//        Method m = ms.getMethod();
//        System.out.println("方法规则式拦截:"+ m.getName());
//    }
}
