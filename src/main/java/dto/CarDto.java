package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor

public class CarDto {
    private Integer id;
    private String model;
    private String brand;
    private Integer year;
}
