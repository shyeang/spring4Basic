package shyeang.spring.bean.javaConfig.service;

import org.springframework.stereotype.Service;

@Service
public class UseFunctionService {

    FunctionService functionService;

    public UseFunctionService(FunctionService f){
        functionService = f;
    }

    public String useFunction(String word){
        return functionService.sayHello(word);
    }
}
