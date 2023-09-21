package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.specification.SpecificationFuncionario;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class RelatorioFuncionarioDinamico {

    private final FuncionarioRepository funcionarioRepository;

    public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> buscaDeFuncionariosDinamica(final String nome, final BigDecimal salario, final String cpf) {
        return funcionarioRepository.findAll(Specification.where(
                SpecificationFuncionario.nome(nome)
                        .or(SpecificationFuncionario.salario(salario))
                        .or(SpecificationFuncionario.cpf(cpf))));
    }
}
