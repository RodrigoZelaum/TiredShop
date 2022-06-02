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
        budgetDto.setAddress(budget.getAddress());
        return budgetDto;
    }

    public Budget toModel(BudgetDto budgetDto) {
        Budget budget = new Budget();
        budget.setId(budgetDto.getId());
        budget.setAddress(budgetDto.getAddress());

        return budget;
    }

    public String save(BudgetDto budgetDto) {
        Budget saveBudget = toModel(budgetDto);
        budgetRepository.save(saveBudget);
        return "Budget successfully saved";

    }

    public BudgetDto search(Long id) {
        Optional<Budget> budget = budgetRepository.findById(id);
        Budget dataBudget;
        BudgetDto budgetDto = new BudgetDto();

        if (budget.isPresent()) {
            dataBudget = budget.get();
            toDto(dataBudget);
        }
        return budgetDto;
    }

    public void update(Long id, BudgetDto budgetDto) {
        Budget dataBudget = budgetRepository.findById(id).orElseThrow();
        if (budgetDto.getAddress() != null) {
            dataBudget.setAddress(budgetDto.getAddress());
        }

        budgetRepository.save(dataBudget);
    }

    public void delete(Long id) {
        budgetRepository.deleteById(id);
    }

    public List<BudgetDto> listAll() {
        return budgetRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
