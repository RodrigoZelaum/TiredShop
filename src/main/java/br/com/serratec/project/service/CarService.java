package br.com.serratec.project.service;

import br.com.serratec.project.dto.CarDto;
import br.com.serratec.project.model.Car;
import br.com.serratec.project.repository.CarRepository;
import br.com.serratec.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    ClientRepository clientRepository;

    public CarDto toDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setBrand(car.getBrand());
        carDto.setModel(car.getModel());
        carDto.setYear(car.getYear());

        return carDto;
    }

    public Car toModel(CarDto carDto) {
        Car car = new Car();
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setYear(carDto.getYear());

        return car;
    }

    public String save(CarDto carDto) {
        Car saveCar = toModel(carDto);
        carRepository.save(saveCar);
        return "car successfully saved";
    }

    public CarDto searchById(Long id) {
        Optional<Car> car = carRepository.findById(id);
        Car dataCar;
        CarDto carDto = new CarDto();

        if (car.isPresent()) {
            dataCar = car.get();
            toDto(dataCar);
        }
        return carDto;
    }

    public String update(Long id, CarDto carDto) {
        Optional<Car> car = carRepository.findById(id);
        Car dataCar = new Car();

        if (car.isPresent()) {
            dataCar = car.get();
            if (carDto.getBrand() != null) {
                dataCar.setBrand(carDto.getBrand());
            }
            if (carDto.getYear() != null) {
                dataCar.setYear(carDto.getYear());
            }
            if (carDto.getModel() != null) {
                dataCar.setModel(carDto.getModel());
            }
            carRepository.save(dataCar);
        }
        return "Car successfully updated";
    }

    public String delete(Long id) {
        carRepository.deleteById(id);
        return "Car successfully deleted";
    }

    public List<CarDto> listAll() {
        List<Car> carList = carRepository.findAll();
        List<CarDto> carDtoList = new ArrayList<>();
        for (Car car : carList) {
            CarDto carDto = toDto(car);
            carDtoList.add(carDto);
        }
        return carDtoList;
    }
}
