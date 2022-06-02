package br.com.serratec.project.model;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="model")
    private String model;

    @Column(name="brand")
    private String brand;

    @Column(name="year")
    private String year;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private OrderService order;

}
