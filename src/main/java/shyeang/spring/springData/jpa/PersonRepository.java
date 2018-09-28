package shyeang.spring.springData.jpa;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor {

    List<Person> findAllByNameNotNull();

    List<Person> findByAddress(String address);

    Person findByNameAndAddress(String name, String address);

    @Query("select p from Person p where p.name = :name and p.address = :address")
    Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

    @Query("select p from Person p where p.name = ?1 and p.address = ?2")
    Person withNameAndAddressIndexQuery(String name, String address);

    Person withNameAndAddressNameQuery(String name, String address);

    List<Person> findByName(String name, Sort sort);

    Page<Person> findByName(String name, Pageable pageable);
}
