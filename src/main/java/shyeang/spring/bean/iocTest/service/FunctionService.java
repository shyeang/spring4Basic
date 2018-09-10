package shyeang.spring.bean.iocTest.service;

import org.springframework.stereotype.Service;

@Service
public class FunctionService {
    public String sayHello(String word){
        return  "hello" + "---" + word;
    }
}
