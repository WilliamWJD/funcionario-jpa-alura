package br.com.alura.spring.data.service;

import br.com.alura.spring.data.dto.FuncionarioInputDto;
import br.com.alura.spring.data.mapper.FuncionarioMapper;
import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.Unidade;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public Funcionario salvarFuncionario(FuncionarioInputDto funcionarioInputDto) {
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

    public List<Funcionario> buscaFuncionariosPorNome(final String nome) {
        return funcionarioRepository.findByNome(nome);
    }

    public List<Funcionario> buscarPorNomeDataContratacaoESalariosMaior(final String nome, final String data, final BigDecimal salario) {
        // converte string para LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return funcionarioRepository.buscarPorNomeDataContratacaoESalarioMaior(nome, LocalDate.parse(data, formatter), salario);
    }

    public List<Funcionario> buscarPorDataContratacaoMaior(final String data) {
        // converte string para LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return funcionarioRepository.buscarFuncionariosComDataSuperior(LocalDate.parse(data, formatter));
    }

    public Page<Funcionario> listarFuncionarios(final Integer page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.unsorted());
        return funcionarioRepository.findAll(pageable);
    }
}
