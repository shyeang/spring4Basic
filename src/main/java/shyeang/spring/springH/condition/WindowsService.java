package shyeang.spring.springH.condition;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Service
@Conditional(WindowCondition.class)
public class WindowsService implements  ListService {
    @Override
    public String showListCmd() {
        return "for windows";
    }
}
