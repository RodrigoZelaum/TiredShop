package br.com.serratec.project.model;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="model")
    private String model;

    @Column(name="brand")
    private String brand;

    @Column(name="year")
    private Integer year;

    @ManyToOne
    private Budget budget;


    public Car(Integer id, String model, String brand, Integer year) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.year = year;
    }
}
