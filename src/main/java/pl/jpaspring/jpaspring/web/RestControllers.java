package pl.jpaspring.jpaspring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.jpaspring.jpaspring.DTO.CustomerDTO;
import pl.jpaspring.jpaspring.entity.CustomerEntity;
import pl.jpaspring.jpaspring.queries.CustomerRepo;
import pl.jpaspring.jpaspring.web.json.TestJSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RestController
public class RestControllers {

    @Autowired
    CustomerRepo customerRepo;

    @PutMapping(produces = {"application/json"})
    @RequestMapping(value = "/test")
    public TestJSON greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new TestJSON(1,
                "Hello! " + name);
    }
    @PutMapping(produces = {"application/json"})
    @RequestMapping(value = "/getall")
    public List<CustomerDTO> getAll() {
        List<CustomerDTO> json = new ArrayList<>();
        customerRepo.selectAll().forEach(customer -> {
            json.add(customer.toDTO());
        });
        return json;
    }

    @PutMapping(produces = {"application/json"})
    @RequestMapping(value = "/getbylastname")
    public List<CustomerDTO> getByName(@RequestParam(value="lastname") String lastname) {
        List<CustomerDTO> json = new ArrayList<>();
        customerRepo.selectByLastName(lastname).forEach(customer -> {
            if (customer != null) {
                json.add(customer.toDTO());
            }
        });
        return json;
    }
}
