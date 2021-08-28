package pl.sda.thymeleaf.domain.develop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.sda.thymeleaf.domain.employee.Employee;
import pl.sda.thymeleaf.domain.employee.EmployeeRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

@Component
@Profile("dev")
@RequiredArgsConstructor
public class EmployeeMockData {

    private final EmployeeRepository repository;

    @Value("${employee.mockEntries}")
    private Integer numberOfEntries;

    private static final List<String> NAMES = List.of("Rafal", "Jarek", "Dawid", "Alicja", "Alan", "Marta", "Bartek");
    private static final List<String> LASTNAMES = List.of("Golota", "Saleta", "Kaczka", "Najman", "Zero", "Blad", "Ziobro");
    private static final List<String> EMAILS = List.of("golota@o2.pl", "saleta@o2.pl", "kaczka@o2.pl", "najman@o2.pl", "zero@o2.pl", "blad@o2.pl", "ziobro@o2.pl");
    private static final List<String> PESELS = List.of("65102713166", "02300238288", "50060673922", "60060755955", "50110962484",
            "05211119543", "61012894342", "98010633712", "75111334135", "77072574878", "94061545129");


    @PostConstruct
    public void initializeEmployees() {
        int namesSize = NAMES.size();
        int lastNamesSize = LASTNAMES.size();
        int emailsSize = EMAILS.size();
        int peselsSize = PESELS.size();

        Random random = new Random();

        for (int i = 0; i < numberOfEntries; i++) {
            Employee employee = createEmployee(
                    NAMES.get(random.nextInt(namesSize)),
                    LASTNAMES.get(random.nextInt(lastNamesSize)),
                    EMAILS.get(random.nextInt(emailsSize)),
                    PESELS.get(random.nextInt(peselsSize)),
                    random.nextInt(100));
            repository.save(employee);
        }
    }

    private Employee createEmployee(String name, String lastName, String email, String pesel, Integer age) {
        return new Employee()
                .setName(name)
                .setSurname(lastName)
                .setEmail(email)
                .setPesel(pesel)
                .setAge(age);
    }
}
