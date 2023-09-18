package br.com.alura.spring.data.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioInputDto {
    private Integer id;
    private String nome;
    private String cpf;
    private BigDecimal salario;
    private Integer cargoId;
    private List<Integer> unidadesDeTrabalhoId = new ArrayList<>();

    public FuncionarioInputDto(){
    }

    public FuncionarioInputDto(Integer id, String nome, String cpf, BigDecimal salario, Integer cargoId, List<Integer> unidadesDeTrabalhoId) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.cargoId = cargoId;
        this.unidadesDeTrabalhoId = unidadesDeTrabalhoId;
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

    public Integer getCargoId() {
        return cargoId;
    }

    public void setCargoId(Integer cargoId) {
        this.cargoId = cargoId;
    }

    public List<Integer> getUnidadesDeTrabalhoId() {
        return unidadesDeTrabalhoId;
    }

    public void setUnidadesDeTrabalhoId(List<Integer> unidadesDeTrabalhoId) {
        this.unidadesDeTrabalhoId = unidadesDeTrabalhoId;
    }

    @Override
    public String toString() {
        return "FuncionarioInputDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", salario=" + salario +
                ", cargoId=" + cargoId +
                ", unidadesDeTrabalhoId=" + unidadesDeTrabalhoId +
                '}';
    }
}
