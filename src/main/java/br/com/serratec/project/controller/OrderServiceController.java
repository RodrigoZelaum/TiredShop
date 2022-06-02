package br.com.serratec.project.controller;

import br.com.serratec.project.dto.OrderServiceDto;
import br.com.serratec.project.exception.OrderException;
import br.com.serratec.project.service.OrderSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderServiceController {
    @Autowired
    OrderSService orderService;

    @GetMapping("/all")
    public List<OrderServiceDto> getAll() {
        return orderService.listAll();
    }

    @GetMapping("/{id}")
    public OrderServiceDto getById(@PathVariable Long id) throws OrderException {
        return orderService.findOneOrder(id);
    }

    @PostMapping()
    public String saveOrder(@RequestBody OrderServiceDto orderDto) {
        return orderService.save(orderDto);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
    }

    @PutMapping("{id}")
    public void updateOrder(@PathVariable Long id, @RequestBody OrderServiceDto order) {
        orderService.update(id, order);
    }

}

