package io.github.cursodsousa.clientes.logicanegocio;

import io.github.cursodsousa.clientes.dominio.Cliente;
import io.github.cursodsousa.clientes.dominio.exception.CpfInvalidoException;
import io.github.cursodsousa.clientes.utilitario.GerenciadorArquivos;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LojaCadastroMemoria implements Cadastro<Cliente>{

    private List<Cliente> lista;

    public LojaCadastroMemoria() {
        this.lista = new ArrayList<>();
    }

    @Override
    public void salvar(Cliente cliente) throws CpfInvalidoException {
        ValidadorCliente.validar(cliente);
        this.lista.add(cliente);
        GerenciadorArquivos.persistirArquivo(cliente.getNome() +
                ".jpg", cliente.getFoto());
    }

    @Override
    public Optional<Cliente> buscar(UUID codigo) {

        Cliente clienteEncontrado = null;

        for(Cliente c : this.lista){
            if(c.getCodigo().equals(codigo)){
                clienteEncontrado = c;
                break;
            }
        }

        return Optional.ofNullable(clienteEncontrado);
    }

    @Override
    public void deletar(UUID codigo) {

        //Tres formas de trabalhar com o Optional

        //Optional<Cliente> clienteEncontrado = this.buscar(codigo) ;
       /* if(clienteEncontrado.isPresent()){
        lista.remove(clienteEncontrado.get());*/

        /*this.buscar(codigo)
                .ifPresent(cliente -> lista.remove(cliente));*/

        this.buscar(codigo)
                .ifPresentOrElse(cliente -> lista.remove(cliente),
                        () -> System.out.println("Cliente nao removido, pois codigo era inexistente"));

    }

    @Override
    public void atualizar(Cliente objetoAtualizar) {

    }

    @Override
    public void imprimirRegistros() {

        System.out.println("Imprimindo " + this.lista.size() + " clientes");
        for(Cliente cliente : this.lista){
            System.out.println(cliente);
        }
    }
}
