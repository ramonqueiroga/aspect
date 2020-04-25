package com.example.aspect.service;

import com.example.aspect.dominio.Nome;
import org.springframework.stereotype.Service;

@Service
public class TesteService {

    public Nome meuNome(String nomeStr) {
        Nome nome = new Nome();
        nome.setNome(nomeStr);
        return nome;
    }

}
