package br.com.serratec.project.controller;

import br.com.serratec.project.dto.BudgetDto;
import br.com.serratec.project.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budget")
public class BudgetController {

    @Autowired
    BudgetService bugdgetService;

    @GetMapping("/all")
    public List<BudgetDto> getAll() {
        return bugdgetService.listAll();
    }

    @GetMapping("/{id}")
    public BudgetDto getById(@PathVariable Long id) {
        return bugdgetService.search(id);
    }

    @PostMapping()
    public String saveCar(@RequestBody BudgetDto carDto) {
        return bugdgetService.save(carDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        bugdgetService.delete(id);
    }

    @PutMapping("{id}")
    public void updateCar(@PathVariable Long id, @RequestBody BudgetDto car) {
        bugdgetService.update(id, car);
    }
}
