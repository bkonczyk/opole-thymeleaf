package pl.sda.thymeleaf.domain.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "employees")
@Data
@Accessors(chain = true)
public class Employee {

    @Id
    private UUID id = UUID.randomUUID();

    private String name;

    private String surname;

    private String email;

    private String pesel;

    private Integer age;
}
