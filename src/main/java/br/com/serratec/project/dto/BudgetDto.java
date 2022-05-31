package br.com.serratec.project.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
public class BudgetDto {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    private String price;
    private String service;
    private Date data;


}
