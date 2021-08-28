package pl.sda.thymeleaf.domain.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    public String empty() {
        return "redirect:/index";
    }

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

    @PostMapping("/add-employee")
    public String addEmployee(@Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "add-employee-form";
        }
        service.saveEmployee(employee);
        return "redirect:/index";
    }

    @GetMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable UUID id) {
        service.deleteEmployee(id);
        return "redirect:/index";
    }
}
