package shyeang.spring.springH.springAware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import sun.nio.ch.IOUtil;

import java.io.IOException;

@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware{
    private  String beanName;
    private ResourceLoader loader;
    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void outputResult(){
        System.out.println("bean's Name is :" + beanName);
        Resource resource = loader.getResource("springH/aware/test.txt");

        try {
            System.out.println("resourcer loader message:" + IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
