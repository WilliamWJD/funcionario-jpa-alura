package br.com.alura.spring.data.orm;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "funcionarios")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private BigDecimal salario;
    private LocalDate dataContratacao;

    @ManyToOne
    @JoinColumn(name = "cargo_id", nullable = false)
    private Cargo cargo;

    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "funcionarios_unidades", joinColumns = {@JoinColumn(name = "fk_funcionario")}, inverseJoinColumns = {@JoinColumn(name = "fk_unidade")})
    private List<Unidade> unidadeTrabalhos = new ArrayList<>();

    public Funcionario(){
    }
    public Funcionario(Integer id, String nome, String cpf, BigDecimal salario, LocalDate dataContratacao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Unidade> getUnidadeTrabalhos() {
        return unidadeTrabalhos;
    }

    public void setUnidadeTrabalhos(List<Unidade> unidadeTrabalhos) {
        this.unidadeTrabalhos = unidadeTrabalhos;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", salario=" + salario +
                ", dataContratacao=" + dataContratacao +
                ", cargo=" + cargo +
                ", unidadeTrabalhos=" + unidadeTrabalhos +
                '}';
    }
}
