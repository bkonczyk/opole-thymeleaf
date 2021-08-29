package pl.sda.thymeleaf.domain.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    @Value("${pageSize}")
    private int pageSize;

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public void saveEmployee(Employee employee) {
        repository.save(employee);
    }

    public void deleteEmployee(UUID id) {
        repository.deleteById(id);
    }

    public Page<Employee> findPage(int pageNo) {
        PageRequest pageRequest = PageRequest.of(--pageNo, pageSize);
        return repository.findAll(pageRequest);
    }

    public Employee get(UUID id) {
        return repository.findById(id).orElse(new Employee());
    }
}
