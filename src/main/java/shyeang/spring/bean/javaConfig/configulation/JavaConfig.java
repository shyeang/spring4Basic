package shyeang.spring.bean.javaConfig.configulation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shyeang.spring.bean.javaConfig.service.FunctionService;
import shyeang.spring.bean.javaConfig.service.UseFunctionService;

@Configuration
public class JavaConfig {
    @Bean
    public FunctionService functionService(){
        return  new FunctionService();
    }

    @Bean
    public UseFunctionService useFunctionService(){
        return  new UseFunctionService(functionService());
    }
}
