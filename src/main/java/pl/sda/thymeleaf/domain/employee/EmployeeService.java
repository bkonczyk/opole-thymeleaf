package pl.sda.thymeleaf.domain.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public List<Employee> findAll() {
        return repository.findAll();
    }
}
