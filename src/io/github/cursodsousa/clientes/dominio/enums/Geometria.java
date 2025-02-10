package io.github.cursodsousa.clientes.dominio.enums;

import io.github.cursodsousa.clientes.dominio.Cliente;

public class Geometria {
    public static void main(String[] args) {
        FormaGeometrica formaGeometrica = FormaGeometrica.RETANGULO;
        int ladosRetangulo = formaGeometrica.getLados();
        System.out.println(ladosRetangulo);

        Cliente cliente = new Cliente();
        cliente.setNome("Fulano");
        cliente.setCpf("0123");
        cliente.setSexo(TipoSexo.F);

        Cliente outroCliente = new Cliente();
        outroCliente.setCodigo(cliente.getCodigo());
        outroCliente.setNome("Fulano");
        outroCliente.setCpf("0123");
        outroCliente.setSexo(TipoSexo.F);

        System.out.println(cliente.hashCode());
        System.out.println(outroCliente.hashCode());

        //false pois compara o seu espaço em memoria
        System.out.println(cliente == outroCliente);

        //true pois o equals compara suas propriedades
        System.out.println(cliente.equals(outroCliente));

    }
}
