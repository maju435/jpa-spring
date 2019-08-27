package pl.jpaspring.jpaspring.queries;

import pl.jpaspring.jpaspring.entity.CustomerEntity;

import java.util.List;

public interface CustomerRepo {
    public void save(CustomerEntity aCustomerEntity);
    public List<CustomerEntity> selectByLastName(String aLastName);
    public List<CustomerEntity> selectAll();
    public void delete(String aLastName);
}
