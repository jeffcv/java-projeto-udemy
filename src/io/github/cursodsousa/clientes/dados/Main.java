package io.github.cursodsousa.clientes.dados;

import io.github.cursodsousa.clientes.dominio.Cliente;
import io.github.cursodsousa.clientes.dominio.enums.TipoSexo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

import static io.github.cursodsousa.clientes.dados.FabricaConexoes.criarConexao;

public class Main {
    public static void main(String[] args) throws SQLException {

        exemploInsert();

        var conexao = FabricaConexoes.criarConexao();
        ClienteDAO dao = new ClienteDAO(conexao);

        List<Cliente> lista = dao.listar();

        lista.forEach(System.out::println);

    }

    private static void exemploDeletar() throws SQLException {
        var conexao = FabricaConexoes.criarConexao();
        ClienteDAO dao = new ClienteDAO(conexao);

        dao.deletar(UUID.fromString("602cc90b-37e1-4ea1-a271-ee64fe420581"));

        conexao.close();
    }

    private static void exemploAtualizar() throws SQLException {

        var conexao = FabricaConexoes.criarConexao();
        ClienteDAO dao = new ClienteDAO(conexao);

        Cliente cliente = new Cliente();
        cliente.setCodigo(UUID.fromString("602cc90b-37e1-4ea1-a271-ee64fe420581"));
        cliente.setNome("Zezinho da silva");
        cliente.setSexo(TipoSexo.M);
        cliente.setCpf("01234567890");
        cliente.setIdade(20);

        dao.atualizar(cliente);

        conexao.close();
    }

    private static void exemploInsert() throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setNome("Zezinho");
        cliente.setSexo(TipoSexo.M);
        cliente.setCpf("01234567890");
        cliente.setIdade(20);

        var conexao = criarConexao();
        ClienteDAO dao = new ClienteDAO(conexao);

        dao.inserir(cliente);

        conexao.close();
    }
}
