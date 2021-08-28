package pl.sda.thymeleaf.domain.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "employees")
@Data
@Accessors(chain = true)
public class Employee {

    @Id
    private UUID id = UUID.randomUUID();
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotEmpty(message = "Surname should not be empty")
    private String surname;
    @Email(message = "Invalid email")
    @NotEmpty(message = "E-mail is required")
    private String email;
    @PESEL(message = "Invalid pesel")
    private String pesel;
    @Range(min = 0, max = 150, message = "You're not alive")
    @NotNull(message = "Age is required")
    private Integer age;
}
