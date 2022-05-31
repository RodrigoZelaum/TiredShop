package br.com.serratec.project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class CarDto {
    private Integer id;
    private String model;
    private String brand;
    private Integer year;
}
