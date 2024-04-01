package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


@Controller
@RequestMapping(value = "/cars")
public class CarsController {

    private final CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String printCarsRange(@RequestParam(value = "count", required = false) Optional<Integer> quantity, Model model) {
        if (quantity.isEmpty()) {
            model.addAttribute("cars", carService.getCars());
        } else {
            model.addAttribute("cars", carService.getCarsByQuantity(quantity.get()));
        }
        return "cars";
    }
}
