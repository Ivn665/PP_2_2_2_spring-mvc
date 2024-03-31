package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.CarService;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/cars")
public class CarsController {

    private final CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String printCarsRange(HttpServletRequest request, Model model) {
        try {
            int quantity = Integer.parseInt(request.getParameter("count"));
            model.addAttribute("cars", carService.getCarsByQuantity(quantity));
        } catch (NumberFormatException e) {
            model.addAttribute("cars", carService.getCars());
        }
        return "cars";
    }
}
