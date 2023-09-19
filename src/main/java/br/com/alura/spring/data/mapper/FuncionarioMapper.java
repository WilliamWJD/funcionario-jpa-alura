package br.com.alura.spring.data.mapper;

import br.com.alura.spring.data.dto.FuncionarioInputDto;
import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.Unidade;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Component
public class FuncionarioMapper {

    public Funcionario funcionarioInputDtoParaFuncionarioEntidade(FuncionarioInputDto funcionarioInputDto, Cargo cargo, List<Unidade> unidadesTrabalho){
        Funcionario funcionario  = new Funcionario();

        if(!Objects.nonNull(funcionarioInputDto.getId())){
            funcionario.setId(funcionarioInputDto.getId());
        }

        funcionario.setNome(funcionarioInputDto.getNome());
        funcionario.setSalario(funcionarioInputDto.getSalario());
        funcionario.setCpf(funcionarioInputDto.getCpf());
        funcionario.setCargo(cargo);
        funcionario.setUnidadeTrabalhos(unidadesTrabalho);
        funcionario.setDataContratacao(LocalDate.now());

        return funcionario;
    }
}
