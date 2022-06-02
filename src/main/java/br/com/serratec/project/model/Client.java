package br.com.serratec.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private OrderService orderService;

    public Client(String name, String cpf, String email, String telephone) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.telephone = telephone;
    }

    public Client(Long id, String name, String cpf, String email, String telephone, OrderService orderService) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.telephone = telephone;
        this.orderService = orderService;
    }

    public Client() {
    }
}

