package br.com.alura.spring.data.resources;

import br.com.alura.spring.data.dto.FuncionarioInputDto;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {

    private final CrudFuncionarioService crudFuncionarioService;

    public FuncionarioResource(CrudFuncionarioService crudFuncionarioService) {
        this.crudFuncionarioService = crudFuncionarioService;
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvar(@RequestBody final FuncionarioInputDto funcionarioInputDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(crudFuncionarioService.salvarFuncionario(funcionarioInputDto));
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> buscaPorNome(@RequestParam("nome") final String nome) {
        return ResponseEntity.ok(crudFuncionarioService.buscaFuncionariosPorNome(nome));
    }

    @GetMapping("/busca")
    public ResponseEntity<List<Funcionario>> buscarPorNomeDataContratacaoESalarioMaior(
            @RequestParam("nome") final String nome,
            @RequestParam("data") final String data,
            @RequestParam("salario") final BigDecimal salario
    ) {
        return ResponseEntity.ok(crudFuncionarioService.buscarPorNomeDataContratacaoESalariosMaior(nome, data, salario));
    }

    @GetMapping("/busca/dataMaior")
    public ResponseEntity<List<Funcionario>> buscarPorDataContratacaoMaior(@RequestParam("data") final String data) {
        return ResponseEntity.ok(crudFuncionarioService.buscarPorDataContratacaoMaior(data));
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<Funcionario>> listarFuncionarios(@RequestParam("page") final Integer page, @RequestParam("sort") final String sort) {
        return ResponseEntity.ok(crudFuncionarioService.listarFuncionarios(page, sort));
    }
}
