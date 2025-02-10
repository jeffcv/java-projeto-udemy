package estudo.colecoes;

import io.github.cursodsousa.clientes.dominio.Cliente;
import io.github.cursodsousa.clientes.dominio.enums.TipoSexo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        OrganizacaoClientes cadastro = new OrganizacaoClientes();

        List<Cliente> listaClientes = new ArrayList<>();
        Cliente cliente = new Cliente();
        cliente.setCpf("0123");
        cliente.setNome("Cicrano");
        cliente.setSexo(TipoSexo.M);

        cadastro.adicionar(cliente);

        Cliente cliente2 = new Cliente();
        cliente2.setCpf("0124");
        cliente2.setNome("Maria");
        cliente2.setSexo(TipoSexo.F);

        cadastro.adicionar(cliente2);

        Cliente cliente3 = new Cliente();
        cliente3.setCpf("0124");
        cliente3.setNome("Rita");
        cliente3.setSexo(TipoSexo.F);

        cadastro.adicionar(cliente3);

        Cliente cliente4 = new Cliente();
        cliente4.setCpf("0124");
        cliente4.setNome("Alguem");
        cliente4.setSexo(TipoSexo.O);

        cadastro.adicionar(cliente4);

        System.out.println("Femininos:");
        cadastro.imprimirClientes(TipoSexo.F);

        System.out.println("Masculinos:");
        cadastro.imprimirClientes(TipoSexo.M);

        System.out.println("Outros:");
        cadastro.imprimirClientes(TipoSexo.O);

        List<TipoSexo> tipoSexos = cadastro.obterTiposAdicionados();
        for(TipoSexo sexo : tipoSexos){
            System.out.println(sexo.getDescricao());
        }
    }

    private static void exemplosMaps() {
        Map<Integer, String> mapa = new HashMap<>();
        mapa.put(1, "Fulano");
        mapa.put(2, "Cicrano");
        mapa.put(3, "Maria");

        String nome = mapa.get(3);
        System.out.println(nome);

        mapa.remove(1);

        System.out.println(mapa.get(1));

        boolean contemChave = mapa.containsKey(2);
        System.out.println("Contem a chave " + contemChave);

        boolean contemValor = mapa.containsValue("Fulano");
        System.out.println("Contem o valor " + contemValor);
    }

    private static void trabalhandoComOrdenacaoDeColecoes() {
        List<Cliente> listaClientes = new ArrayList<>();
        Cliente cliente = new Cliente();
        cliente.setCpf("0123");
        cliente.setNome("Cicrano");
        cliente.setSexo(TipoSexo.M);

        Cliente cliente2 = new Cliente();
        cliente2.setCpf("0124");
        cliente2.setNome("Cicrano");
        cliente2.setSexo(TipoSexo.F);

        List<Cliente> clientes = Arrays.asList(cliente, cliente2);

        clientes.sort(Cliente::compareTo);

        //classe anonima pra usar outro criterio de comparacao, desassociado da minha Classe

        clientes.sort(new Comparator<Cliente>() {
            @Override
            public int compare(Cliente o1, Cliente o2) {
                return o1.getCodigo().compareTo(o2.getCodigo());
            }
        });

        for(Cliente c : clientes){
            System.out.println(c);
        }
    }

    private static void repositorioComHash(){
        Set<String> linguagens = new HashSet<>();
        linguagens.add("Java");
        linguagens.add("Python");
        linguagens.add("Javascript");
        linguagens.add("java");

        for(String l : linguagens){
            System.out.println(l);
        }
    }

    private static void repositorioComList(){
        List<Cliente> listaClientes = new ArrayList<>();
        Cliente cliente = new Cliente();
        cliente.setCpf("0123");
        cliente.setNome("Fulano");
        cliente.setSexo(TipoSexo.M);

        Cliente cliente2 = new Cliente();
        cliente2.setCpf("0124");
        cliente2.setNome("Cicrano");
        cliente2.setSexo(TipoSexo.F);

        listaClientes.add(cliente);
        listaClientes.add(cliente2);

        System.out.println(listaClientes.size());

        System.out.println(listaClientes.contains(cliente));

        for(Cliente c : listaClientes){
            System.out.println(c);
        }
    }

    private static void repositorioComArray(){
        RepositorioClientes repositorioClientes = new RepositorioClientes();
        Cliente cliente = new Cliente();
        cliente.setCpf("0123");
        cliente.setNome("Fulano");
        cliente.setSexo(TipoSexo.M);

        Cliente cliente2 = new Cliente();
        cliente2.setCpf("0124");
        cliente2.setNome("Cicrano");
        cliente2.setSexo(TipoSexo.F);

        repositorioClientes.adicionar(cliente);
        repositorioClientes.adicionar(cliente2);

        repositorioClientes.imprimirClientes();
    }
}
