package service;

import dto.CarDto;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

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

    public CarDto searchById(Integer car_id) {
        Optional<Car> car = carRepository.findById(car_id);
        Car dataCar;
        CarDto carDto = new CarDto();

        if (car.isPresent()) {
            dataCar = car.get();
            toDto(dataCar);
        }
        return carDto;
    }

    public String update(Integer car_id, CarDto carDto) {
        Optional<Car> car = carRepository.findById(car_id);
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

    public String delete(Integer car_id) {
        carRepository.deleteById(car_id);
        return "Car successfully deleted";
    }

    public List<CarDto> listAll() {
        List<Car> carList = carRepository.findAll();
        List<CarDto> carDtoList = new ArrayList<>();
        for (Car car : carList) {
            CarDto carDto = new CarDto();
            toDto(car);
            carDtoList.add(carDto);
        }
        return carDtoList;
    }
}
