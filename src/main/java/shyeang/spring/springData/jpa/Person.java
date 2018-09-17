package shyeang.spring.springData.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Person.withNameAndAddressNameQuery",
        query="select p from Person p where p.name=?1 and p.address=?2")
public class Person {
    @Id
    private Long id;

    private String name;
    private Integer age;
    private String address;

    public Person(){

    }
    public Person(Long _id, String _name, Integer _age, String _address){
        id = _id;
        name = _name;
        age = _age;
        address = _address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
