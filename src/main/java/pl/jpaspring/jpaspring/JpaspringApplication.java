package pl.jpaspring.jpaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.jpaspring.jpaspring.entity.CustomerEntity;
import pl.jpaspring.jpaspring.queries.CustomerRepo;
import pl.jpaspring.jpaspring.queries.CustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaspringApplication {

    @Autowired
    CustomerRepo customerRepo;

	public static void main(String[] args) {
		SpringApplication.run(JpaspringApplication.class, args);
	}

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new CustomerEntity("Jack", "Bauer", new Date()));
            repository.save(new CustomerEntity("Chloe", "O'Brian", new Date()));
            repository.save(new CustomerEntity("Kim", "Bauer", new Date()));
            repository.save(new CustomerEntity("Zenek", "Martyniuk", new Date()));
            repository.save(new CustomerEntity("Maria", "Motyka", new Date()));
            repository.save(new CustomerEntity("Janusz", "Nowak", new Date()));

            // fetch all customers
            System.out.println("Customers found with findAll():");
            System.out.println("-------------------------------");
            for (CustomerEntity customer : repository.findAll()) {
                System.out.println(customer.toDTO().toString());
            }
            System.out.println("");

            // fetch an individual customer by ID
            repository.findById(1L)
                    .ifPresent(customer -> {
                        System.out.println("Customer found with findById(1L):");
                        System.out.println("--------------------------------");
                        System.out.println(customer.toString());
                        System.out.println("");
                    });

            // fetch customers by last name
            System.out.println("Customer found with findByLastName('Bauer'):");
            System.out.println("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                System.out.println(bauer.toDTO().toString());
            });

            repository.findByLastName("O'Brian").forEach(brian -> {
                repository.delete(brian);
            });
            System.out.println("");

            // fetch all customers
            System.out.println("Customers found with findAll() after delete O'Brian:");
            System.out.println("-------------------------------");
            for (CustomerEntity customer : repository.findAll()) {
                System.out.println(customer.toDTO().toString());
            }
            System.out.println("");

            List<CustomerEntity> customers = customerRepo.selectByLastName("Bauer");

            System.out.println("Customers found with findAll() by EntityManager:");
            System.out.println("-------------------------------");
            for (CustomerEntity customer : customers) {
                System.out.println(customer.toDTO().toString());
            }

            System.out.println("");
        };
    }

}
