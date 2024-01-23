package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import java.util.Optional;

@Controller
public class CarController {
    private final CarService carService;
    public CarController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping(value="/cars")
    public String printCars(@RequestParam(required = false) Optional<String> count, ModelMap model) {

        int cnt = 0;
        try {
            cnt = Integer.parseInt(count.orElse("5"));
        } catch (NumberFormatException ignored) { }

        model.addAttribute("cars", carService.getCars(cnt));

        return "cars";
    }
}
