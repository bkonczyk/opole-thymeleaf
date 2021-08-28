package pl.sda.thymeleaf.domain.develop;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.sda.thymeleaf.domain.employee.EmployeeRepository;

import java.util.List;

@Component
@Profile("dev")
@RequiredArgsConstructor
public class EmployeeMockData {

    private static final List<String> NAMES = List.of("Rafal", "Jarek", "Dawid", "Alicja", "Alan", "Marta", "Bartek");
    private static final List<String> LASTNAMES = List.of("Golota", "Saleta", "Kaczka", "Najman", "Zero", "Blad", "Ziobro");
    private static final List<String> EMAILS = List.of("golota@o2.pl", "saleta@o2.pl", "kaczka@o2.pl", "najman@o2.pl", "zero@o2.pl", "blad@o2.pl", "ziobro@o2.pl");
    private static final List<String> PESELS = List.of("65102713166", "02300238288", "50060673922", "60060755955", "50110962484",
            "05211119543", "61012894342", "98010633712", "75111334135", "77072574878", "94061545129");

    private final EmployeeRepository repository;

//        private String name;
//    private String surname;
//    private String email;
//    private String pesel;
//    private Integer age;

}
