package pl.sda.thymeleaf.domain.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping("/index")
    public String index(Model model) {
        List<Employee> employees = service.findAll();
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/add-employee-form")
    public String addEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add-employee-form";
    }
}
