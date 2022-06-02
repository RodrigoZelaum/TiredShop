package br.com.serratec.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "price")
    private double price;
    @Column(name="date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;
    @Column(name = "diagnostic")
    private String diagnostic;

    @OneToOne
    private Car car;

    @OneToOne
    private Budget budget;

    @OneToOne
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
