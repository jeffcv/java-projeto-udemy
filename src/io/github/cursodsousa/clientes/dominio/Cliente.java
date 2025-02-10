package io.github.cursodsousa.clientes.dominio;

import io.github.cursodsousa.clientes.dominio.enums.TipoSexo;

import java.util.Arrays;
import java.util.UUID;

public class Cliente implements Comparable<Cliente> {
    private UUID codigo;
    private String nome;
    private String cpf;
    private Integer idade;
    private TipoSexo sexo;
    private Boolean ativo;
    private byte[] foto;

    public Cliente() {
        this.codigo = UUID.randomUUID();
        System.out.println("Código do cliente: " + this.codigo.toString());
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public TipoSexo getSexo() {
        return sexo;
    }

    public void setSexo(TipoSexo sexo) {
        this.sexo = sexo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", sexo=" + sexo +
                ", foto=" + Arrays.toString(foto) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;
        return codigo.equals(cliente.codigo) && nome.equals(cliente.nome) && cpf.equals(cliente.cpf) && sexo == cliente.sexo;
    }

    @Override
    public int hashCode() {
        int result = codigo.hashCode();
        result = 31 * result + nome.hashCode();
        result = 31 * result + cpf.hashCode();
        result = 31 * result + sexo.hashCode();
        return result;
    }

    @Override
    public int compareTo(Cliente o) {
        int fator = this.nome.compareTo(o.getNome());
        if (fator == 0) {
            fator = this.sexo.equals(TipoSexo.F) ? -1 : 1;
        }
        return fator;
    }
}
