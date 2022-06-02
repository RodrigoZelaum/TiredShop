package br.com.serratec.project.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Date;


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
