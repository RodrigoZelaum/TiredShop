package br.com.serratec.project.controller;

import br.com.serratec.project.dto.CarDto;
import br.com.serratec.project.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("/all")
    public List<CarDto> getAllCars() {
        return carService.listAll();
    }

    @GetMapping("/{id}")
    public CarDto getCarById(@PathVariable Long id) {
        return carService.searchById(id);
    }

    @PostMapping()
    public String saveCar(@RequestBody CarDto carDto) {
        return carService.save(carDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.delete(id);
    }

    @PutMapping("/{id}")
    public void updateCar(@PathVariable Long id, @RequestBody CarDto car) {
        carService.update(id, car);
    }

}


