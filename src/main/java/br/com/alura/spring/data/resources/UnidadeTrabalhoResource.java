package br.com.alura.spring.data.resources;

import br.com.alura.spring.data.orm.Unidade;
import br.com.alura.spring.data.service.CrudUnidadeTrabalhoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidade")
public class UnidadeTrabalhoResource {

    private final CrudUnidadeTrabalhoService crudUnidadeTrabalhoService;

    public UnidadeTrabalhoResource(CrudUnidadeTrabalhoService crudUnidadeTrabalhoService){
        this.crudUnidadeTrabalhoService = crudUnidadeTrabalhoService;
    }

    @PostMapping
    public ResponseEntity<Unidade> salvar(@RequestBody final Unidade unidade){
        return ResponseEntity.status(HttpStatus.CREATED).body(crudUnidadeTrabalhoService.salvarUnidadeDeTrabalho(unidade));
    }

    @GetMapping
    public ResponseEntity<List<Unidade>> listar(){
        return ResponseEntity.ok(crudUnidadeTrabalhoService.listarUnidadesDeTrabalho());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidade> buscarPorId(@PathVariable(name = "id") final Integer id){
        return ResponseEntity.ok(crudUnidadeTrabalhoService.buscarUnidadeDeTrabalhoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Unidade> atualizar(@PathVariable(name = "id") final Integer id, @RequestBody final Unidade unidade){
        return ResponseEntity.ok(crudUnidadeTrabalhoService.atualizarUnidadeDeTrabalho(id, unidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletear(@PathVariable(name = "id") final Integer id){
        crudUnidadeTrabalhoService.deletaUnidadeDeTrabalho(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
