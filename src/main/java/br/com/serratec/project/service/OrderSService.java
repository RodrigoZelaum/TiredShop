package br.com.serratec.project.service;

import br.com.serratec.project.dto.OrderServiceDto;
import br.com.serratec.project.exception.OrderException;
import br.com.serratec.project.model.Budget;
import br.com.serratec.project.model.Car;
import br.com.serratec.project.model.Client;
import br.com.serratec.project.model.OrderService;
import br.com.serratec.project.repository.BudgetRepository;
import br.com.serratec.project.repository.CarRepository;
import br.com.serratec.project.repository.ClientRepository;
import br.com.serratec.project.repository.OrderServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrderSService {
    @Autowired
    private OrderServiceRepository orderRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private BudgetRepository budgetRepository;
    @Autowired
    ClientRepository clientRepository;

    public OrderServiceDto toDto(OrderService orderModel) {
        Car car = new Car();
        Client client = new Client();
        Budget budget = new Budget();
        OrderServiceDto orderDto = new OrderServiceDto();
        orderDto.setId(orderModel.getId());
        orderDto.setDiagnostic(orderModel.getDiagnostic());
        orderDto.setDate(orderModel.getDate());
        orderDto.setPrice(orderModel.getPrice());
        orderDto.setCarId(car.getId());
        orderDto.setClientId(client.getId());
        orderDto.setBudgetId(budget.getId());

        return orderDto;
    }

    public OrderService toModel(OrderServiceDto orderDto) {
        OrderService orderModel = new OrderService();
        orderModel.setId(orderDto.getId());
        orderModel.setDiagnostic(orderDto.getDiagnostic());
        orderModel.setDate(orderDto.getDate());
        orderModel.setPrice(orderDto.getPrice());

        return orderModel;
    }

    public String save(OrderServiceDto orderDto) {
        OrderService orderService = toModel(orderDto);
        orderService.setCar(carRepository.findById(orderDto.getCarId()).orElseThrow());
        orderService.setBudget(budgetRepository.findById(orderDto.getBudgetId()).orElseThrow());
        orderService.setClient(clientRepository.findById(orderDto.getClientId()).orElseThrow());
        orderRepository.save(orderService);
        return "Order successfully saved";
    }


    public OrderService getOrderOrElseThrow(Long id) throws OrderException {
        return this.orderRepository.findById(id).orElseThrow();
    }

    public OrderServiceDto findOneOrder(Long id) throws OrderException {
        var exc = new OrderException("Order not Found");
        return toDto(this.getOrderOrElseThrow(id));
    }

    public void update(Long id, OrderServiceDto serviceDto) {
        OrderService orderService = orderRepository.findById(id).orElseThrow();
        if (serviceDto.getDiagnostic() != null) {
            orderService.setDiagnostic(serviceDto.getDiagnostic());
        }
        if (serviceDto.getDate() != null) {
            orderService.setDate(serviceDto.getDate());
        }
        if (serviceDto.getPrice() != null) {
            orderService.setPrice(serviceDto.getPrice());
        }
        orderRepository.save(orderService);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    public List<OrderServiceDto> listAll() {
        return orderRepository.findAll()
                .stream()
                .map(this::toDto)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
