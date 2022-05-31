package br.com.serratec.project.model;

import lombok.*;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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

    @ManyToOne
    private Client client;
}
