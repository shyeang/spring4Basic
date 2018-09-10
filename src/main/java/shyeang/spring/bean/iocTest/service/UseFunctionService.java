package shyeang.spring.bean.iocTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseFunctionService {
    @Autowired
    FunctionService functionService;

    public String useFunction(String word){
        return functionService.sayHello(word);
    }
}
