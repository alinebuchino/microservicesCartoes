package io.github.alinebuchino.msclientes.application.dto;

import io.github.alinebuchino.msclientes.domain.Cliente;
import lombok.Data;

@Data
public class ClienteSaveRequest {

    private String cpf;
    private String nome;
    private Integer idade;

    public Cliente toModal(){
        return new Cliente(cpf, nome, idade);
    }
}
