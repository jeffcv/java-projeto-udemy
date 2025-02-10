package estudo.funcional;

public class Main {
    public static void main(String[] args) {

        //Classe anonima

        Calculadora soma = new Calculadora() {
            @Override
            public int calcular(int x, int y) {
                return x + y;
            }
        };

        //expressao lambda

        soma = (x, y) -> x + y;

        System.out.println("Adicao: " + soma.calcular(2,2));

        Calculadora subtracao = (num1, num2) -> num1 - num2;

        System.out.println("Subtracao: " + subtracao.calcular(20,10));

        //sem parametro - mas se tiver 1 nao precisa de parenteses
        Executor executor = param -> subtracao.calcular(50,30);

        executor.executa(50);
    }
}
