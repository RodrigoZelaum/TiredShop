package br.com.serratec.project.service;


import br.com.serratec.project.model.Budget;
import br.com.serratec.project.model.Car;
import br.com.serratec.project.model.Client;
import br.com.serratec.project.repository.BudgetRepository;
import br.com.serratec.project.repository.CarRepository;
import br.com.serratec.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AutoInsertDevService {

    @Autowired
    BudgetRepository budgetRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    ClientRepository clientRepository;

    public void testInsertUser() {
        Client client = new Client("Mario", "154.545.464-34", "email", "(21)966609888");

        Set<Client> clients = new HashSet<>();
        clients.add(new Client("Mario", "154.545.464-34", "email", "(21)966609888"));


        Car car = new Car("Sport", "Ford", "1980");
        carRepository.save(car);


        Budget budget = new Budget("Rua SuperBlasterMasterFly, nª 777 - Rio de Janeiro");
        budgetRepository.save(budget);
    }
}
