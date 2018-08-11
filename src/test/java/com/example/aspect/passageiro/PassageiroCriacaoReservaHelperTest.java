package com.example.aspect.passageiro;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PassageiroCriacaoReservaHelperTest {

    @Test
    public void teste6() {
        List<Passageiro> passageiros = new ArrayList<>();
        passageiros.add(this.novoPassageiro("Francinete", "Barbosa", FaixaEtaria.ADT));
        passageiros.add(this.novoPassageiro("Fernanda", "Cristina Toledo", FaixaEtaria.ADT));
        passageiros.add(this.novoPassageiro("Ramon", "Barbosa", FaixaEtaria.INF));

        PassageiroCriacaoReservaHelper helper = new PassageiroCriacaoReservaHelper();
        List<PassageiroCriacaoReserva> passageirosProntos = helper.definePassageirosCriacaoReserva(passageiros);
        assertNotNull(passageirosProntos);
    }

    @Test
    public void teste5() {
        List<Passageiro> passageiros = new ArrayList<>();
        passageiros.add(this.novoPassageiro("Francinete", "Barbosa", FaixaEtaria.CHD));
        passageiros.add(this.novoPassageiro("Fernanda", "Cristina Toledo", FaixaEtaria.CHD));

        PassageiroCriacaoReservaHelper helper = new PassageiroCriacaoReservaHelper();
        List<PassageiroCriacaoReserva> passageirosProntos = helper.definePassageirosCriacaoReserva(passageiros);
        assertNotNull(passageirosProntos);
    }

    @Test
    public void teste4() {
        List<Passageiro> passageiros = new ArrayList<>();
        passageiros.add(this.novoPassageiro("Francinete", "Barbosa", FaixaEtaria.ADT));
        passageiros.add(this.novoPassageiro("Ramon", "de Araujo Queiroga", FaixaEtaria.ADT));
        passageiros.add(this.novoPassageiro("Fernanda", "Cristina Toledo", FaixaEtaria.CHD));
        passageiros.add(this.novoPassageiro("Rodrigo", "Barbosa", FaixaEtaria.INF));

        PassageiroCriacaoReservaHelper helper = new PassageiroCriacaoReservaHelper();
        List<PassageiroCriacaoReserva> passageirosProntos = helper.definePassageirosCriacaoReserva(passageiros);
        assertNotNull(passageirosProntos);
    }

    @Test
    public void teste3() {
        List<Passageiro> passageiros = new ArrayList<>();
        passageiros.add(this.novoPassageiro("Fernanda", "Cristina Toledo", FaixaEtaria.ADT));
        passageiros.add(this.novoPassageiro("Francinete", "Martins de Araujo", FaixaEtaria.ADT));
        passageiros.add(this.novoPassageiro("Sebastiao", "Queiroga", FaixaEtaria.ADT));
        passageiros.add(this.novoPassageiro("Ramon", "de Araujo Queiroga", FaixaEtaria.CHD));
        passageiros.add(this.novoPassageiro("Felipe", "de Araujo Queiroga", FaixaEtaria.INF));
        passageiros.add(this.novoPassageiro("Rodrigo", "Barbosa", FaixaEtaria.INF));

        PassageiroCriacaoReservaHelper helper = new PassageiroCriacaoReservaHelper();
        List<PassageiroCriacaoReserva> passageirosProntos = helper.definePassageirosCriacaoReserva(passageiros);
        assertNotNull(passageirosProntos);
    }

    @Test
    public void teste2() {
        List<Passageiro> passageiros = new ArrayList<>();
        passageiros.add(this.novoPassageiro("Fernanda", "Cristina Toledo", FaixaEtaria.ADT));
        passageiros.add(this.novoPassageiro("Ramon", "de Araujo Queiroga", FaixaEtaria.CHD));
        passageiros.add(this.novoPassageiro("Felipe", "de Araujo Queiroga", FaixaEtaria.INF));

        PassageiroCriacaoReservaHelper helper = new PassageiroCriacaoReservaHelper();
        List<PassageiroCriacaoReserva> passageirosProntos = helper.definePassageirosCriacaoReserva(passageiros);
        assertNotNull(passageirosProntos);
    }

    @Test
    public void teste() {
        List<Passageiro> passageiros = new ArrayList<>();
        passageiros.add(this.novoPassageiro("Fernanda", "de Araujo Queiroga", FaixaEtaria.ADT));
        passageiros.add(this.novoPassageiro("Ramon", "de Araujo Queiroga", FaixaEtaria.ADT));
        passageiros.add(this.novoPassageiro("Felipe", "de Araujo Queiroga", FaixaEtaria.INF));
        passageiros.add(this.novoPassageiro("Joao", "de Araujo Queiroga", FaixaEtaria.INF));

        PassageiroCriacaoReservaHelper helper = new PassageiroCriacaoReservaHelper();
        List<PassageiroCriacaoReserva> passageirosProntos = helper.definePassageirosCriacaoReserva(passageiros);
        assertNotNull(passageirosProntos);
    }

    Passageiro novoPassageiro(String nome, String sobrenome, FaixaEtaria faixaEtaria) {
        Passageiro passageiro = new Passageiro();
        passageiro.setFaixaEtaria(faixaEtaria);
        passageiro.setNome(nome);
        passageiro.setSobrenome(sobrenome);
        return passageiro;
    }

}