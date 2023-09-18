package br.com.alura.spring.data.service;

import br.com.alura.spring.data.dto.FuncionarioInputDto;
import br.com.alura.spring.data.mapper.FuncionarioMapper;
import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.Unidade;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrudFuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final CrudCargoService crudCargoService;
    private final CrudUnidadeTrabalhoService crudUnidadeTrabalhoService;
    private final FuncionarioMapper funcionarioMapper;

    public CrudFuncionarioService(FuncionarioRepository funcionarioRepository, CrudCargoService crudCargoService, CrudUnidadeTrabalhoService crudUnidadeTrabalhoService, FuncionarioMapper funcionarioMapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.crudCargoService = crudCargoService;
        this.crudUnidadeTrabalhoService = crudUnidadeTrabalhoService;
        this.funcionarioMapper = funcionarioMapper;
    }
    @Transactional
    public Funcionario salvarFuncionario(FuncionarioInputDto funcionarioInputDto){
        // recupera cargo
        Cargo cargo = crudCargoService.buscarCargoPorId(funcionarioInputDto.getCargoId());

        // lista de unidades de trabalho
        List<Unidade> unidadesDeTrabalho = new ArrayList<>();

        // valida unidades de trabalho
        funcionarioInputDto.getUnidadesDeTrabalhoId().forEach(und -> unidadesDeTrabalho.add(crudUnidadeTrabalhoService.buscarUnidadeDeTrabalhoPorId(und)));

        // mapper funcinonario
        Funcionario funcionario = funcionarioMapper.funcionarioInputDtoParaFuncionarioEntidade(funcionarioInputDto, cargo, unidadesDeTrabalho);

        // salva funcionario
        return funcionarioRepository.save(funcionario);
    }
}
