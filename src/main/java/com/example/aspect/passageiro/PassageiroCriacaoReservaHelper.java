package com.example.aspect.passageiro;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PassageiroCriacaoReservaHelper {

    private static final Comparator<Passageiro> PAX_COMPARATOR = (p1, p2) -> {
        int nomePax1 = p1.getNomeCompleto().length();
        int nomePax2 = p2.getNomeCompleto().length();
        return nomePax1 - nomePax2;
    };

    public List<PassageiroCriacaoReserva> definePassageirosCriacaoReserva(List<Passageiro> passageiros) {
        List<PassageiroCriacaoReserva> passageirosCriacaoPorSobreNome = this.montaPassageirosVinculadosPorSobreNome(passageiros);
        List<Passageiro> passageirosAdultosVinculados = passageirosCriacaoPorSobreNome.stream()
                .map(PassageiroCriacaoReserva::getPassageiro)
                .collect(Collectors.toList());
        List<Passageiro> passageirosInfantisVinculados = passageirosCriacaoPorSobreNome.stream()
                .map(PassageiroCriacaoReserva::getPassageiroRef)
                .collect(Collectors.toList());
        passageiros.removeAll(passageirosAdultosVinculados);
        passageiros.removeAll(passageirosInfantisVinculados);

        List<PassageiroCriacaoReserva> passageirosCriacaoPorTamanhoDoNome = this.montaPassageirosVinculadosPorTamanhoNome(passageiros);
        passageirosAdultosVinculados = passageirosCriacaoPorTamanhoDoNome.stream()
                .map(PassageiroCriacaoReserva::getPassageiro)
                .collect(Collectors.toList());
        passageirosInfantisVinculados = passageirosCriacaoPorTamanhoDoNome.stream()
                .map(PassageiroCriacaoReserva::getPassageiroRef)
                .collect(Collectors.toList());
        passageiros.removeAll(passageirosAdultosVinculados);
        passageiros.removeAll(passageirosInfantisVinculados);

        List<PassageiroCriacaoReserva> passageirosSemVinculo = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(passageiros)) {
            for (Passageiro passageiro : passageiros) {
                PassageiroCriacaoReserva passageiroCriacaoReserva = new PassageiroCriacaoReserva();
                passageiroCriacaoReserva.setPassageiro(passageiro);
                passageirosSemVinculo.add(passageiroCriacaoReserva);
            }
        }

        List<PassageiroCriacaoReserva> passageirosProntos = new ArrayList<>();
        passageirosProntos.addAll(passageirosCriacaoPorSobreNome);
        passageirosProntos.addAll(passageirosCriacaoPorTamanhoDoNome);
        passageirosProntos.addAll(passageirosSemVinculo);
        return passageirosProntos;
    }

    private List<PassageiroCriacaoReserva> montaPassageirosVinculadosPorTamanhoNome(List<Passageiro> passageiros) {
        List<Passageiro> passageirosAdts = passageiros.stream().filter(pax -> pax.getFaixaEtaria() == FaixaEtaria.ADT).collect(Collectors.toList());
        List<Passageiro> passageirosInfs = passageiros.stream().filter(pax -> pax.getFaixaEtaria() == FaixaEtaria.INF).collect(Collectors.toList());
        passageirosAdts.sort(PAX_COMPARATOR);

        List<PassageiroCriacaoReserva> passageirosCriacao = new ArrayList<>();
        for (int i = 0; i < passageirosInfs.size(); i++) {
            if(passageirosAdts.get(i) != null) {
                PassageiroCriacaoReserva passageiroCriacaoReserva = new PassageiroCriacaoReserva();
                passageiroCriacaoReserva.setPassageiro(passageirosAdts.get(i));
                passageiroCriacaoReserva.setPassageiroRef(passageirosInfs.get(i));
                passageirosCriacao.add(passageiroCriacaoReserva);
            }
        }

        return passageirosCriacao;
    }

    private List<PassageiroCriacaoReserva> montaPassageirosVinculadosPorSobreNome(List<Passageiro> passageiros) {
        List<Passageiro> passageirosAdts = passageiros.stream().filter(pax -> pax.getFaixaEtaria() == FaixaEtaria.ADT).collect(Collectors.toList());
        List<Passageiro> passageirosInfs = passageiros.stream().filter(pax -> pax.getFaixaEtaria() == FaixaEtaria.INF).collect(Collectors.toList());
        List<PassageiroCriacaoReserva> passageirosVinculados = new ArrayList<>();
        List<Passageiro> controlePassageiros = new ArrayList<>();
        for (Passageiro paxAdt : passageirosAdts) {
            for (Passageiro paxInf : passageirosInfs) {
                if(paxAdt.getSobrenome().equals(paxInf.getSobrenome()) && !controlePassageiros.contains(paxInf)) {
                    PassageiroCriacaoReserva passageiroCriacaoReserva = new PassageiroCriacaoReserva();
                    passageiroCriacaoReserva.setPassageiro(paxAdt);
                    passageiroCriacaoReserva.setPassageiroRef(paxInf);
                    passageirosVinculados.add(passageiroCriacaoReserva);
                    controlePassageiros.add(paxInf);
                    break;
                }
            }
        }

        return passageirosVinculados;
    }

}
