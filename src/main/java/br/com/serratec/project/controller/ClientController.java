package br.com.serratec.project.controller;

import br.com.serratec.project.dto.ClientDto;
import br.com.serratec.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping()
    public List<ClientDto> getAllClients() {
        return clientService.listAll();
    }

    @GetMapping("/{id}")
    public ClientDto getClientById(@PathVariable Integer id) {
        return clientService.searchById(id);
    }

    @PostMapping()
    public String saveClient(@RequestBody ClientDto clientDto) {
        return clientService.saveClient(clientDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Integer id)  {
        clientService.delete(id);
    }

    @PutMapping("{id}")
    public void updateCar(@PathVariable int id, @RequestBody ClientDto car)  {
        clientService.update(id, car);
    }

}

