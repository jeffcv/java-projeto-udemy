package io.github.cursodsousa.clientes.logicanegocio;

import java.util.Optional;

public class Teste {
    public static void main(String[] args) {
        Optional<String> optionalName = findName("Johnn");

        // Verifica e processa o valor se presente
        optionalName.ifPresent(name -> System.out.println("Nome encontrado: " + name));

        // Retorna um valor padrão se estiver vazio
        String name = optionalName.orElse("Nome não encontradoo");
        System.out.println(name);
    }

    public static Optional<String> findName(String query) {
        if ("John".equals(query)) {
            return Optional.of("John Doe");
        }
        return Optional.empty();
    }
    }
