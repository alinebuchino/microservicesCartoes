package io.github.alinebuchino.msavaliadorcredito.application;

import feign.FeignException;
import io.github.alinebuchino.msavaliadorcredito.application.exceptions.DadosClientesNotFoundException;
import io.github.alinebuchino.msavaliadorcredito.application.exceptions.ErroComunicacaoMicroservicesException;
import io.github.alinebuchino.msavaliadorcredito.domain.model.CartoesCliente;
import io.github.alinebuchino.msavaliadorcredito.domain.model.DadosCliente;
import io.github.alinebuchino.msavaliadorcredito.domain.model.SituacaoCliente;
import io.github.alinebuchino.msavaliadorcredito.infra.clients.CartoesResourceClient;
import io.github.alinebuchino.msavaliadorcredito.infra.clients.ClienteResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final ClienteResourceClient clientesClient;
    private final CartoesResourceClient cartoesClient;

    // obterDadosClientes - msClientes
    // obterCartoesClientes - msCartoes

    public SituacaoCliente obterSituacaoCliente(String cpf) throws DadosClientesNotFoundException, ErroComunicacaoMicroservicesException{

        try{
            ResponseEntity<DadosCliente> dadosClienteResponse = clientesClient.dadosCliente(cpf);
            ResponseEntity<List<CartoesCliente>> dadosCartoesClienteResponse = cartoesClient.cartoesClientes(cpf);

            return SituacaoCliente
                    .builder()
                    .cliente(dadosClienteResponse.getBody())
                    .cartoes(dadosCartoesClienteResponse.getBody())
                    .build();
        } catch (FeignException.FeignClientException e){
            int status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status){
                throw new DadosClientesNotFoundException();
            }
            throw new ErroComunicacaoMicroservicesException(e.getMessage(), status);
        }
    }
}
