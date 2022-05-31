package br.com.serratec.project.controller;

import br.com.serratec.project.dto.CarDto;
import br.com.serratec.project.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/program")
public class CarController {
        @Autowired
        CarService carService;

        @GetMapping("/cars")
        public List<CarDto> getAllCars() {
            return carService.listAll();
        }

        @GetMapping("/car/{id}")
        public CarDto getCarById(@PathVariable int id) {
            return carService.searchById(id);
        }

        @PostMapping("/save/cars")
        public String saveCar(@RequestBody CarDto carDto) {
            return carService.save(carDto);
        }

        @DeleteMapping("/delete/car/{id}")
        public void deleteCar(@PathVariable Integer id)  {
            carService.delete(id);
        }

        @PutMapping("/update/car/{id}")
        public void updateCar(@PathVariable int id, @RequestBody CarDto car)  {
            carService.update(id, car);
        }

    }


