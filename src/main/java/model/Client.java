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
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "client_id")
    private Integer id;

    @Column(name = "client_name")
    private String name;

    @Column(name = "client_cpf")
    private String cpf;

    @Column(name = "client_email")
    private String email;

    @Column(name = "client_telephone")
    private String telephone;

    @OneToMany (mappedBy = "client")
    private Set<Car> car;
}

