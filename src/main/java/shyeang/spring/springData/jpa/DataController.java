package shyeang.spring.springData.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DataController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")
    public Person save(String name, String addr, Integer age){
        Person p = new Person(null, name, age, addr);
        personRepository.save(p);
        return p;
    }

    @RequestMapping("/ql")
    @ResponseBody
    public List<Person> ql(String  addr){
        List<Person> lp = personRepository.findByAddress(addr);
        return lp;
    }

    @RequestMapping("/qs")
    @ResponseBody
    public Person qs(String name, String  addr){
        Person p = personRepository.withNameAndAddressNameQuery(name, addr);
        return p;
    }


}