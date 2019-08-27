package pl.jpaspring.jpaspring.queries;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.jpaspring.jpaspring.DTO.CustomerDTO;
import pl.jpaspring.jpaspring.entity.CustomerEntity;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CustomerRepoImplTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CustomerRepo customerRepo;

    @Before
    public void setUp() throws Exception {

        // given
        CustomerEntity customerTest1 = new CustomerEntity("Jan","Kowalski", new Date());
        CustomerEntity customerTest2 = new CustomerEntity("Anna","Kowalski", new Date());

        entityManager.persist(customerTest1);
        entityManager.flush();
        entityManager.persist(customerTest2);
        entityManager.flush();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void save() {
    }

    @Test
    public void selectByLastName() {

        // when
        List<CustomerEntity> found = customerRepo.selectByLastName("Kowalski");
        assert found != null;
        // then
        assert found.size() == 2;
        found.forEach(customer -> {
            assert "Kowalski".equals(customer.toDTO().getLastName());
        });
    }

    @Test
    public void selectAll() {
        // when
        List<CustomerEntity> found = customerRepo.selectAll();
        assert found != null;
        // then
        assert found.size() > 0;
        found.forEach(customer -> {
            assertNotNull(customer);
        });
    }

    @Test
    public void delete() {
    }
}