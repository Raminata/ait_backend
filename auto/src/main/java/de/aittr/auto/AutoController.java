package de.aittr.auto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/auto")
public class AutoController {

    private AutoService service;



    public AutoController(AutoService service) {
        this.service = service;
    }


    @GetMapping
    public String getAllAuto(Model model) {
        List<Auto> cars = service.getAllAuto();
        model.addAttribute("auto", cars);
        return  "auto_view";

    }
}
