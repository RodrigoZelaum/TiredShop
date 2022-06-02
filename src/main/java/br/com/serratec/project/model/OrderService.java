package br.com.serratec.project.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "order_service")
public class OrderService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "price")
    private double price;
    @Column(name = "date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;
    @Column(name = "diagnostic")
    private String diagnostic;


    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    @OneToOne
    @JoinColumn(name = "budget_id", referencedColumnName = "id")
    private Budget budget;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    public OrderService() {
    }

    public OrderService(Long id, double price, Date date, String diagnostic, Car car, Budget budget, Client client) {
        this.id = id;
        this.price = price;
        this.date = date;
        this.diagnostic = diagnostic;
        this.car = car;
        this.budget = budget;
        this.client = client;
    }


}
