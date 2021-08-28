package pl.sda.thymeleaf.domain.starter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StarterController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name, final Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
