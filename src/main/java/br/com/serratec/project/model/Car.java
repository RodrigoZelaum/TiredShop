package br.com.serratec.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name = "Car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "brand")
    private String brand;

    @Column(name = "year")
    private String year;

    public Car(String model, String brand, String year) {
        this.model = model;
        this.brand = brand;
        this.year = year;

    }

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private OrderService order;

    public Car() {
    }

    public Car(Long id, String model, String brand, String year, OrderService order) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.order = order;
    }
}
