package pl.jpaspring.jpaspring.queries;

import pl.jpaspring.jpaspring.entity.CustomerEntity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

public class CustomerRepoImpl implements CustomerRepo{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(CustomerEntity aCustomerEntity) {
        if (aCustomerEntity != null) {
            em.persist(aCustomerEntity);
        }
    }

    @Override
    public List<CustomerEntity> selectByLastName(String aLastName) {
        List<CustomerEntity> customers = Collections.emptyList();
        if (aLastName != null) {
            customers = em.createQuery(
                    "select c from CustomerEntity c where c.lastName =" + aLastName,
                    CustomerEntity.class)
                    .getResultList();
        }
        return customers;
    }

    @Override
    public List<CustomerEntity> selectAll() {
        List<CustomerEntity> customers = Collections.emptyList();
        customers = em.createQuery(
                "select c from CustomerEntity c",
                CustomerEntity.class)
                .getResultList();
        return customers;
    }

    @Override
    public void delete(String aLastName) {
        if (aLastName != null) {
            em.remove(aLastName);
        }
    }
}
