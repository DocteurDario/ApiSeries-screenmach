package com.aluracursos.screenmach.Principal;

import java.util.Arrays;
import java.util.List;

public class EjemploStreams {

    public void muestraEjemplo() {
        List<String> nombres = Arrays.asList("Brenda", "Luis", "Eric", "Genesys");

        nombres.stream()
                .sorted()
                .limit(4)
                .filter(n -> n.startsWith("L"))
                .map(n -> n.toUpperCase())
                .forEach(System.out::println);
    }
}
