package pl.jpaspring.jpaspring.queries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import pl.jpaspring.jpaspring.entity.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

    List<CustomerEntity> findByLastName(String lastName);
}