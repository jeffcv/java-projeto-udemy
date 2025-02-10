package estudo.strings;

import javax.print.attribute.standard.PrinterMessageFromOperator;

public class Main {

    static String valor = "Maçã";

    public static void main(String[] args) {
        String hello = "Hello";

        System.out.println("Parece com hello " + hello.equalsIgnoreCase("HelLO"));
        System.out.println("Começa com H?: " + hello.startsWith("H"));
        System.out.println("Termina com O?: " + hello.endsWith("lo"));

        String nomeCompleto = "Fulano da Silva Sauro";
        String[] partesDoNome = nomeCompleto.split(" ");
        for (int i = 0; i < partesDoNome.length; i++){
            System.out.println(partesDoNome[i]);
        }
        /*System.out.println(partesDoNome[0]);
        System.out.println(partesDoNome[1]);
        System.out.println(partesDoNome[2]);
        System.out.println(partesDoNome[3]);*/


    }

    private static void tamanhoString() {
        int tamanho = valor.length();
        System.out.println("Tamanho: " + tamanho);
    }

    private static void pegarCaracteres() {
        char primeiro = valor.charAt(0);
        char ultimo = valor.charAt(valor.length() - 1);
        System.out.println("Primeiro caractere: " + primeiro);
        System.out.println("Ultimoo caractere: " + ultimo);

    }

    private static void trabalhandoComSubstring() {
        String pedaco = valor.substring(0, 2);
        System.out.println("pedaco da string: " + pedaco);
    }

    private static void exemploIndexOf() {
        int indice = valor.indexOf("R");
        System.out.println("indice letra a: " + indice);

        //-1 valor nao encontrado
        String nome = "Pedro da Sousa";

        indice = nome.indexOf("Silva");

        System.out.println("Indice encontrado " + indice);

        if (nome.indexOf("Silva") != -1) {
            System.out.println("Encontrei " + nome);
        } else {
            System.out.println("Não encontrei esse pedaco no nome");
        }
    }

    private static void exemplosCase() {
        String string = "Silva";

        String caixaAlta = string.toUpperCase();
        System.out.println("Caixa Alta: " + caixaAlta);

        String caixaBaixa = string.toLowerCase();
        System.out.println("Caixa Baixa: " + caixaBaixa);

    }

    private static void removerEspacosEmBranco() {
        String string = "       Pedro da Silva ";
        String stringSemOsEspacos = string.trim();
        System.out.println(stringSemOsEspacos.length());
        System.out.println(stringSemOsEspacos);
    }

    private static void replace() {
        String novaMaca = valor
                .replace("ã", "a")
                .replace("ç", "c");
        System.out.println(novaMaca);

        String cpf = "012.345.678-90";
        System.out.println(cpf
                .replace(".", "")
                .replace("-",""));
    }

}
