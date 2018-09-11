package shyeang.spring.springH.condition;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Service
@Conditional(LinuxCondition.class)
public class LinuxService implements  ListService {
    @Override
    public String showListCmd() {
        return "for linux";
    }
}
