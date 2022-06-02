package br.com.serratec.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "budget")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToOne(mappedBy = "budget", cascade = CascadeType.ALL)
    private OrderService orderService;

    public Budget() {
    }

    public Budget(Long id, String address, OrderService orderService) {
        this.id = id;
        this.address = address;
        this.orderService = orderService;
    }

    public Budget(String address) {
        this.address = address;
    }
}
