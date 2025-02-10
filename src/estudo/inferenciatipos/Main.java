package estudo.inferenciatipos;

import io.github.cursodsousa.clientes.dominio.Cliente;
import io.github.cursodsousa.clientes.logicanegocio.LogicaCadastroClienteFake;

public class Main {
    public static void main(String[] args) {
        int numero = 10;
        double flutuante;

        flutuante = 10d;

        var outroNumero = 15;

        var cliente = new Cliente();
        var logica = new LogicaCadastroClienteFake();

    }
}
