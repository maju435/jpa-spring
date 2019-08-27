package pl.jpaspring.jpaspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import pl.jpaspring.jpaspring.queries.CustomerRepo;
import pl.jpaspring.jpaspring.queries.CustomerRepoImpl;

import javax.sql.DataSource;

@Configuration
class PersistenceContext {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setUrl(
                "jdbc:h2:tcp://localhost:1521/test");

        return dataSource;
    }

    @Bean(name = "CustomerRepo")
    public CustomerRepo customerRepo () {
        return new CustomerRepoImpl();
    }

    //Add the other beans here
}
