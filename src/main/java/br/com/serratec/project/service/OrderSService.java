package br.com.serratec.project.service;

import br.com.serratec.project.dto.OrderServiceDto;
import br.com.serratec.project.exception.OrderException;
import br.com.serratec.project.model.OrderService;
import br.com.serratec.project.repository.OrderServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderSService {
    @Autowired
    OrderServiceRepository orderRepository;

    public OrderServiceDto toDto(OrderService orderModel) {
        OrderServiceDto orderDto = new OrderServiceDto();
        orderDto.setId(orderModel.getId());
        orderDto.setDiagnostic(orderModel.getDiagnostic());
        orderDto.setDate(orderModel.getDate());
        orderDto.setPrice(orderModel.getPrice());

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
        orderRepository.save(orderService);
        return "OrderServiceRepository successfully saved";
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
                .collect(Collectors.toList());
    }
}
