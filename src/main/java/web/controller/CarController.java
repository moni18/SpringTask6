package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping("/cars")
    public String printCars(@RequestParam(value="count", defaultValue = "5") int count, ModelMap model){
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("BWW", "blue", 111));
        carList.add(new Car("Mercedes", "red", 222));
        carList.add(new Car("Kia", "white", 333));
        carList.add(new Car("Hyundai", "grey", 444));
        carList.add(new Car("Toyota", "black", 555));
        carList = CarService.getCars(carList, count);
        model.addAttribute("cars", carList);
        return "car";
    }
}
