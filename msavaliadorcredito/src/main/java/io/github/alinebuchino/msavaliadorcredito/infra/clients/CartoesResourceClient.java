package io.github.alinebuchino.msavaliadorcredito.infra.clients;

import io.github.alinebuchino.msavaliadorcredito.domain.model.Cartao;
import io.github.alinebuchino.msavaliadorcredito.domain.model.CartoesCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "mscartoes", path = "/cartoes")
public interface CartoesResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<List<CartoesCliente>> cartoesClientes(@RequestParam("cpf") String cpf);

    @GetMapping(params = "renda")
    ResponseEntity<List<Cartao>> cartoesRendaAte(@RequestParam("renda") Long renda);
}
