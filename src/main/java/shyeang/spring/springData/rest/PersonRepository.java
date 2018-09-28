package shyeang.spring.springData.rest;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Long>{

    @RestResource(path="findByNameStartsWithPath", rel = "findByNameStartsWithRel")
    List<Person> findByNameStartsWith(@Param("name")String name);

}
