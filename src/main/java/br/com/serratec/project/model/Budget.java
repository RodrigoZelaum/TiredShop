package br.com.serratec.project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "budget")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private Integer id;

    @Column(name="price", nullable = false)
    private String price;

    @Column(name = "service", nullable = false)
    private String service;

    @Column(name="data", nullable = false)
    private Date data;

    @OneToMany(mappedBy = "budget")
    private Set<Car> car;

    public Budget(Integer id, String price, String service, Date data) {
        this.id = id;
        this.price = price;
        this.service = service;
        this.data = data;
    }
}
