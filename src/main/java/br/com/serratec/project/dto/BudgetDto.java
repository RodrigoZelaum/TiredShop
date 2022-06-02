package br.com.serratec.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDto {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String address;

}
