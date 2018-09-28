package shyeang.spring.springData.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static shyeang.spring.springData.jpa.CustomerSpecs.*;

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

    @RequestMapping("/qsi")
    @ResponseBody
    public Person qsi(String name, String  addr){
        Person p = personRepository.withNameAndAddressIndexQuery(name, addr);
        return p;
    }


    @RequestMapping("/qsCriteria")
    @ResponseBody
    public List<Person> qsCriteria(String name, String  addr){
        List<Person> lp = personRepository.findAll(personFromHefei());
        return lp;
    }


    @RequestMapping("/qsSort")
    @ResponseBody
    public List<Person> qsSort(String name){
        List<Person> lp = personRepository.findByName(name, new Sort(Sort.Direction.ASC, "age"));
        return lp;
    }

    @RequestMapping("/qsPage")
    @ResponseBody
    public Page<Person> qsPage(String name){
        Page<Person> lp = personRepository.findByName(name,  PageRequest.of(1, 10,  new Sort(Sort.Direction.ASC, "age")));
        return lp;
    }

    @RequestMapping("/qsAll")
    @ResponseBody
    public List<Person> qsAll(String name){
        List<Person> lp = personRepository.findAllByNameNotNull();
        return lp;
    }


}
