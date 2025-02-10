package estudo.funcional;

import java.util.List;
import java.util.stream.Collectors;

public class EstudoStreams {
    public static void main(String[] args) {
    List<String> nomes = List.of( "Pedro","Ana", "Ana","Mario", "Elizabete","Marcos");

    nomes.stream().forEach(System.out::println);

        System.out.println();
        System.out.println("Filtrando");

    nomes.stream().filter(nome -> nome.length() <= 5)
            .sorted()
            .distinct()
            .forEach(System.out::println);

        System.out.println();

        List<Character> primeirasLetras = nomes.stream()
                .map(nome -> nome.charAt(0))
                .collect(Collectors.toList());

        primeirasLetras.forEach(System.out::println);
    }
}
