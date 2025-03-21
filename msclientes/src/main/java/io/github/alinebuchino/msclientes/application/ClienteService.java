package io.github.alinebuchino.msclientes.application;

import io.github.alinebuchino.msclientes.domain.Cliente;
import io.github.alinebuchino.msclientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    @Transactional
    public Cliente save(Cliente cliente){
        return repository.save(cliente);
    }

    public Optional<Cliente> getByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}
