package br.com.serratec.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderServiceDto {

    private Long id;
    private Double price;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;
    private String diagnostic;
    private Long budgetId;
    private Long clientId;
    private Long carId;

}
