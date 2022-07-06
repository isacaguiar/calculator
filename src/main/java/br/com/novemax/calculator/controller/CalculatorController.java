package br.com.novemax.calculator.controller;

import br.com.novemax.calculator.model.CalculatorModel;
import br.com.novemax.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("calculator", new CalculatorModel());
        return "index";
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/calc", produces = MediaType.APPLICATION_JSON_VALUE)
    public String execute(Model model,
                           @RequestParam String value1,
                           @RequestParam String value2,
                           @RequestParam String operator) {
        //return calculatorService.execute(value1, value2, operator);
        model.addAttribute("calculator", calculatorService.execute(value1, value2, operator));
        return "index";
    }

}
