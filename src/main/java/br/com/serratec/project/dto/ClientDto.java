package br.com.serratec.project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ClientDto {
    private Integer id;
    private String name;
    private String cpf;
    private String email;
    private String telephone;
}
