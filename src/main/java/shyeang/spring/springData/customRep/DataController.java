package shyeang.spring.springData.customRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/auto")
    @ResponseBody
    public Page<Person> auto(Person p){
        Page<Person> pagePeolpe = personRepository.findByAuto(p, new PageRequest(0, 10));

        return pagePeolpe;
    }
}
