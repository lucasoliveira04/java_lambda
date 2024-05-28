## Java Lambda

Uma expressão lambda é um pequeno bloco de código que recebe e retorna um valor. As expressões lamda são semelhantes aos métodos, mas não precisam de nome e podem ser implementadas diretamente no corpo de um método.

Sintaxe
---
    parametro -> expressão

Para usar mais de um parâmetro, coloque-os entre parênteses:
    
    (parametro1, parametro2) -> expressão

As expressões são limitadas. Eles precisam retornar imediatamente um valor e não podem conter variáveis, atribuições ou instruções como if ou for. Para realizar operações mais complexas, um bloco de código pode ser usado com chaves. Se a expressão lambda precisar retornar um valor, o bloco de código deverá ter uma instrução de retorno.

    (parametro1, parametro2) -> { codigo }


Métodos Comuns Usados com Expressões Lambda:
---

``filter``: Filtra elementos com base em uma condição.

``map``: Transforma cada elemento em outro elemento.

``forEach``: Executa uma ação para cada elemento.

``collect``: Coleta os elementos do Stream em uma coleção ou outro contêiner.

``sorted``: Ordena os elementos do Stream.

``distinct``: Remove elementos duplicados do Stream.

``limit``: Limita o número de elementos no Stream.

``skip``: Ignora os primeiros N elementos do Stream.

``peek``: Executa uma ação para cada elemento (geralmente usado para fins de depuração).



Exemplo de Uso com Lambdas:
---
~~~java
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
                .collect(Collectors.collectingAndThen( // Aplica um segundo coletor em um resultado intermediário
                        Collectors.joining(", "), // Primeiro coletor: concatena os nomes com ", " como separador
                        resultConcat -> resultConcat // Função de transformação: adiciona um prefixo ao resultado
                ));

        // Imprimindo a lista resultante
        System.out.println("Final list: " + concat);
    }
}
~~~

