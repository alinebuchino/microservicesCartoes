package io.github.alinebuchino.msavaliadorcredito.application;

import io.github.alinebuchino.msavaliadorcredito.domain.model.DadosCliente;
import io.github.alinebuchino.msavaliadorcredito.domain.model.SituacaoCliente;
import io.github.alinebuchino.msavaliadorcredito.infra.clients.ClienteResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final ClienteResourceClient clientesClient;

    public SituacaoCliente obterSituacaoCliente(String cpf){

        // obterDadosClientes - msClientes

        ResponseEntity<DadosCliente> dadosClienteResponse = clientesClient.dadosCliente(cpf);
        return SituacaoCliente
                .builder()
                .cliente(dadosClienteResponse.getBody())
                .build();
    }

    // obterCartoesClientes - msCartoes
}
