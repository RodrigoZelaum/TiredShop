package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="car_id")
    private Integer id;

    @Column(name="car_model")
    private String model;

    @Column(name="car_brand")
    private String brand;

    @Column(name="car_year")
    private Integer year;

    @ManyToOne
    private TireShop tireShop;
}
