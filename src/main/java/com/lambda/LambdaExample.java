package com.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Lucas", "Oliveira", "Campos", "Bianca", "Santos", "Rafaela", "Gabriel", "leandro");

        List<String> result = names.stream()
                .filter(name -> (name.startsWith("L") || name.startsWith("B")) && name.length() <= 6) // Filtra nomes que começam com 'L' ou 'B' e têm 6 letras
                .map(String::toUpperCase)                    // Converte cada nome para maiúscula
                .distinct()                                  // Remove duplicatas
                .sorted()                                    // Ordena em ordem alfabética
                .peek(name -> System.out.println("Name: " + name)) // Imprime cada nome
                .limit(5)                                    // Limita o resultado aos primeiros 5 elementos
                .collect(Collectors.toList());               // Coleta os resultados em uma lista

        String concat = result.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.joining(", "),
                        resultConcat -> resultConcat
                ));

        // Imprimindo a lista resultante
        System.out.println("Final list: " + concat);
    }
}
