package estudo.exceptions;

import io.github.cursodsousa.clientes.dominio.Cliente;
import io.github.cursodsousa.clientes.dominio.enums.TipoSexo;
import io.github.cursodsousa.clientes.dominio.exception.CpfInvalidoException;
import io.github.cursodsousa.clientes.dominio.exception.DadoObrigatorioException;
import io.github.cursodsousa.clientes.logicanegocio.ValidadorCliente;

import java.time.chrono.ChronoLocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*try {
            Cliente cliente = new Cliente();
            cliente.setSexo(TipoSexo.F);
            String descricao = cliente.getSexo().getDescricao();
            System.out.println(descricao);

        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("O tipo sexo estava null!");
        } catch (Exception e) {
            System.out.println("Erro inexperado!");
        }
        Cliente cliente = new Cliente();
        cliente.setCpf("01234567891");

        try {
            ValidadorCliente.validar(cliente);
            System.out.println("CPF OK!");
        } catch (CpfInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (DadoObrigatorioException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado!");
        } finally {
            System.out.println("Fui executado no finally!");
        }*/

        Scanner scanner = new Scanner(System.in);

        try {
            Cliente c = new Cliente();
            System.out.println("digite o cpf");
            String cpf = scanner.nextLine();
            c.setCpf(cpf);

            ValidadorCliente.validar(c);
        } catch (CpfInvalidoException e) {
            System.out.println("CPF Invalido");
        }
        finally {
            System.out.println("fechando o scanner:");
            scanner.close();
            System.out.println("Scanner fechado");
        }
    }
}
