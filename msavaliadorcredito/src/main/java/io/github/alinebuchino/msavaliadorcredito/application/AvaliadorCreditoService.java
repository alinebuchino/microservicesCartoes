package io.github.alinebuchino.msavaliadorcredito.application;

import io.github.alinebuchino.msavaliadorcredito.domain.model.SituacaoCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    public SituacaoCliente obterSituacaoCliente(String cpf){
        // obterDadosClientes - msClientes
        // obterCartoesClientes - msCartoes
    }
}
