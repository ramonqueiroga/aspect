package com.example.aspect.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarregaDadosConsorcio {

    public static List<Integer> numerosConsorcio() {
        List<Integer> numeros = new ArrayList<>(200);

        for (int i = 1; i <= 200; i++) {
            numeros.add(i);
        }

        return numeros;
    }

    public static List<Integer> numerosEscolhidos() {
        List<Integer> numeros = new ArrayList<>(60);

        for (int i = 1; i <= 60; i++) {
            Random random = new Random();
            int escolhido = random.nextInt(201);
            numeros.add(escolhido);
        }

        return numeros;
    }

}
