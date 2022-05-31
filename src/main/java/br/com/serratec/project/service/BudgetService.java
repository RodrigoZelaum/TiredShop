package br.com.serratec.project.service;

import br.com.serratec.project.dto.BudgetDto;
import br.com.serratec.project.model.Budget;
import br.com.serratec.project.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BudgetService {

    @Autowired
    BudgetRepository budgetRepository;

    public BudgetDto toDto(Budget budget) {
        BudgetDto budgetDto = new BudgetDto();
        budgetDto.setId(budget.getId());
        budgetDto.setService(budget.getService());
        budgetDto.setData(budget.getData());

        return budgetDto;
    }

    public Budget toModel(BudgetDto budgetDto) {
        Budget budget = new Budget();
        budget.setPrice(budgetDto.getPrice());
        budget.setService(budgetDto.getService());
        budget.setData(budgetDto.getData());
        return budget;
    }

    public String save(BudgetDto budgetDto) {
        Budget saveBudget = toModel(budgetDto);
        budgetRepository.save(saveBudget);
        return "Budget successfully saved";

    }

    public BudgetDto search(Integer id) {
        Optional<Budget> budget = budgetRepository.findById(id);
        Budget dataBudget;
        BudgetDto budgetDto = new BudgetDto();

        if (budget.isPresent()) {
            dataBudget = budget.get();
            toDto(dataBudget);
        }
        return budgetDto;
    }

    public void update(Integer id, BudgetDto budgetDto) {
        Budget dataBudget = budgetRepository.findById(id).orElseThrow();
        if (budgetDto.getPrice() != null) {
            dataBudget.setPrice(budgetDto.getPrice());
        }
        if (budgetDto.getService() != null) {
            dataBudget.setService(budgetDto.getService());
        }
        if (budgetDto.getData() != null) {
            dataBudget.setData(budgetDto.getData());
        }

        budgetRepository.save(dataBudget);
    }


    public void delete(Integer id) {
        budgetRepository.deleteById(id);
    }

    public List<BudgetDto> listAll() {
        return budgetRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
