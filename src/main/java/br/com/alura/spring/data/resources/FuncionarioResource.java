package br.com.alura.spring.data.resources;

import br.com.alura.spring.data.dto.FuncionarioInputDto;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {

    private final CrudFuncionarioService crudFuncionarioService;

    public FuncionarioResource(CrudFuncionarioService crudFuncionarioService){
        this.crudFuncionarioService = crudFuncionarioService;
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvar(@RequestBody final FuncionarioInputDto funcionarioInputDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(crudFuncionarioService.salvarFuncionario(funcionarioInputDto));
    }

//    @GetMapping
//    public ResponseEntity<List<Unidade>> listar(){
//        return ResponseEntity.ok(crudUnidadeTrabalhoService.listarUnidadesDeTrabalho());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Unidade> buscarPorId(@PathVariable(name = "id") final Integer id){
//        return ResponseEntity.ok(crudUnidadeTrabalhoService.buscarUnidadeDeTrabalhoPorId(id));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Unidade> atualizar(@PathVariable(name = "id") final Integer id, @RequestBody final Unidade unidade){
//        return ResponseEntity.ok(crudUnidadeTrabalhoService.atualizarUnidadeDeTrabalho(id, unidade));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletear(@PathVariable(name = "id") final Integer id){
//        crudUnidadeTrabalhoService.deletaUnidadeDeTrabalho(id);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
}
