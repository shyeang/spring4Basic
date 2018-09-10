package shyeang.spring.springConfig.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import  org.springframework.core.io.Resource;

import java.io.IOException;


@Configuration
@ComponentScan("shyeang.spring.springConfig.el")
//@PropertySource("classpath:shyeang/spring/springConfig/el/test.properties")
@PropertySource("springConfig/el/test.properties")
public class ELConfig {
    @Value("hello world")
    private String  name;

    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("#{ T(java.lang.Math).random() * 100.0}")
    private double random;

    @Value("#{demoService.another}")
    private  String  fromAnother;

    //@Value("classpath:shyeang/spring/springConfig/el/text.txt")
    @Value("springConfig/el/text.txt")
    private Resource testFile;

    @Value("http://www.baidu.com")
    private  Resource testUrl;

    @Value("${book.name}")
    private  String  bookName;

    @Autowired
    private Environment environment;

    @Bean
    public  static PropertySourcesPlaceholderConfigurer propertyConfig(){
        return  new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResources()   {
        try {
            System.out.println(name);
            System.out.println(osName);
            System.out.println(random);
            System.out.println(fromAnother);


            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
