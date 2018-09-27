package shyeang.spring.springData.customRep;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

public interface PersonRepository extends CustomRepository<Person, Long> {
    List<Person> findByAddress(String addr);

    Person findByNameAndAddress(String name, String addr);

    @Query("select  p from Person  p where p.name=:name and p.address=:addr")
    Person withNameAndAddressQuery(@Param("name")String name, @Param("addr")String addr);

    Person withNameAndAddressNameQuery(String name, String addr);
}
