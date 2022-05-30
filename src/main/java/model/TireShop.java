package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tireshop")

public class TireShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private Integer id;

    @Column(name="cnpj")
    private String cnpj;

    @Column(name="address")
    private String address;

    @Column(name="services")
    private String services;

    @OneToMany(mappedBy = "tireShop")
    private Set<Car> car;

}
