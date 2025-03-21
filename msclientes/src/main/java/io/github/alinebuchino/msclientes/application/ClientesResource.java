package io.github.alinebuchino.msclientes.application;

import io.github.alinebuchino.msclientes.application.dto.ClienteSaveRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("clientes")
@AllArgsConstructor
public class ClientesResource {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity save(@RequestBody ClienteSaveRequest request){
        var cliente = request.toModal();
        service.save(cliente);
        URI headerLocation = ServletUriComponentsBuilder // construir urls no retorno da requisição (com url igual da requisição, ex: http://localhost:8090/clientes?...)
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping
    public ResponseEntity dadosCliente(@RequestParam("cpf") String cpf){
        var cliente = service.getByCpf(cpf);
        if(cliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }
}
