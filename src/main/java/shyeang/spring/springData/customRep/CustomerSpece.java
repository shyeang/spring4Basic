package shyeang.spring.springData.customRep;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CustomerSpece {
    /**
     *1、返回值为Specification，这里使用的是泛型T，所以Specification可以用于任意的实体类
     * @param em
     * @param condition 包含当前值作为查询条件的实体类对象
     * @param <T>
     * @return
     */
    public static <T>Specification<T> byAuto(final EntityManager em, final  T condition){
        //2、获取当前实体类的类型
        final Class<T> type = (Class<T>) condition.getClass();

        return new Specification<T>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //3、新建列表存储构造的查询条件
                List<Predicate> lps = new ArrayList<Predicate>();
                //4、获取实体类的EntityType,可以从中获取实体类的属性
                EntityType<T> et = em.getMetamodel().entity(type);
                //5、对实体类的所有属性进行循环
                for(Attribute<T, ?> attr:et.getDeclaredAttributes()){
                    //6、获取实体类对象某一个属性的值
                    Object attrValue = getValue(condition, attr);
                    //属性条件不为空时
                    if(attrValue!=null){
                        //属性类型为字符串时，使用like对
                        if(attr.getJavaType() == String.class){
                            if(!StringUtils.isEmpty(attrValue)){
                                lps.add(criteriaBuilder.like(root.get(attribute(et,attr.getName(), String.class)), pattern(attrValue.toString())));
                            }
                        } else {
                            lps.add(criteriaBuilder.equal(root.get(attribute(et, attr.getName(), attrValue.getClass())), attrValue));
                        }
                    }
                }


                //11、将条件转列表转换为Predicate
                return lps.isEmpty()?criteriaBuilder.conjunction():criteriaBuilder.and(toArray(lps));
            }

            private Predicate[] toArray(List<Predicate> lp){
                Predicate[] ps = new Predicate[lp.size()];
                return lp.toArray(ps);
            }

            /**
             *
             * 通过反射获得实体类对象对应的属性值
             *
             * @param condition
             * @param attr
             * @param <T>
             * @return
             */
            private <T> Object getValue(T condition, Attribute<T, ?> attr){
                return ReflectionUtils.getField((Field) attr.getJavaMember(), condition);
            }

            /**
             *
             * 获取实体类的当前属性的SingularAttribute， SingularAttribute包含的是实体类的某个单独属性
             *
             * @param et
             * @param fieldName
             * @param fieldClass
             * @param <E>
             * @param <T>
             * @return
             */
            private <E, T> SingularAttribute<T, E> attribute(EntityType<T> et, String fieldName, Class<E> fieldClass){
                return et.getDeclaredSingularAttribute(fieldName, fieldClass);
            }

            private String pattern(String str){
                return "%" + str + "%";
            }
        };
    }

}
