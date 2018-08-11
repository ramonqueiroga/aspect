package com.example.aspect.service;

import com.example.aspect.dominio.Nome;
import org.springframework.stereotype.Service;

@Service
public class TesteService {

    public Nome meuNome() {
        Nome nome = new Nome();
        nome.setNome("Ramon-Araujo-Queiroga");
        return nome;
    }

}
