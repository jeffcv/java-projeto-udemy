package estudo.funcional;

import io.github.cursodsousa.clientes.dominio.Cliente;
import io.github.cursodsousa.clientes.dominio.enums.TipoSexo;
import io.github.cursodsousa.clientes.dominio.exception.CpfInvalidoException;
import io.github.cursodsousa.clientes.logicanegocio.LojaCadastroMemoria;

import java.util.Optional;
import java.util.UUID;

public class EstudoOptional {

    static Optional<Cliente> clienteVazio() {
        return Optional.empty();
    }

    static Optional<Cliente> clientePopulado() {
        var cliente = new Cliente();
        cliente.setNome("Alguem");
        cliente.setSexo(TipoSexo.M);
        cliente.setCpf("01234567890");
        cliente.setIdade(25);

        return Optional.ofNullable(cliente);
    }

    public static void main(String[] args) throws CpfInvalidoException {

        var possivelCliente = new Cliente();
        //possivelCliente.setSexo(TipoSexo.M);

        /*if(possivelCliente.isPresent()){
            var cliente = possivelCliente.get();

            if(cliente.getSexo() != null){
            System.out.println(cliente.getSexo().getDescricao());
            }
        }*/

    var sexoCliente = Optional
            .ofNullable(possivelCliente)
            .map(cliente -> cliente.getSexo())
            .map(tipoSexo -> tipoSexo.getDescricao())
            .orElse(null);

        System.out.println(sexoCliente);



    }

    private static void exemploIfPresent() throws CpfInvalidoException {
        var logica = new LojaCadastroMemoria();

        var cliente = new Cliente();
        cliente.setNome("Alguem");
        cliente.setSexo(TipoSexo.M);
        cliente.setCpf("01234567890");
        cliente.setIdade(25);
        cliente.setFoto(new byte[]{});

        var codigoParaBuscar = cliente.getCodigo();

        logica.salvar(cliente);
        System.out.println("Antes de remover: ");
        logica.imprimirRegistros();

        logica.deletar(UUID.randomUUID());

        System.out.println("Depois de remover:");
        logica.imprimirRegistros();
    }

    private static void trabalhandoComOrElse() {
        Optional<Cliente> possivelCLiente = clienteVazio();

        var cliente = possivelCLiente.orElse(new Cliente());

        //callback, nao estanciou de fato / boa pratica / nao cria novo objeto ocupando memoria
        cliente = possivelCLiente.orElseGet(() -> new Cliente());

        cliente = possivelCLiente
                .orElseThrow(() -> new RuntimeException("O Cliente nao deveria estar vazio!"));

        System.out.println(cliente.getNome());
    }

    private static void exemplosBasicosOptional() {
        var cliente = new Cliente();
        cliente.setNome("Alguem");

        //Optional ajuda em casos que retornara valores ausentes ou presentes
        Optional<Cliente> possivelCliente = Optional.ofNullable(cliente);

        cliente = possivelCliente.get();

        if (possivelCliente.isPresent()) {

            cliente = possivelCliente.get();

            System.out.println(cliente.getNome());
        }

        var logica = new LojaCadastroMemoria();
        var clienteEncontrado = logica.buscar(UUID.randomUUID());

        System.out.println(clienteEncontrado.get().getSexo().getDescricao());
    }
}
