package pl.jpaspring.jpaspring.entity;

import pl.jpaspring.jpaspring.DTO.CustomerDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    public CustomerEntity() {};

    public CustomerEntity(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Date birthDate;

    public CustomerDTO toDTO() {
        CustomerDTO dto = new CustomerDTO();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setBirthDate(birthDate);

        return dto;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
