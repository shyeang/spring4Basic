package shyeang.spring.springData.jpa;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CustomerSpecs {
    public static Specification<Person> personFromHefei(){
        return new Specification<Person>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return  criteriaBuilder.equal(root.get("address"), "合肥");
            }
        };
    }
}
