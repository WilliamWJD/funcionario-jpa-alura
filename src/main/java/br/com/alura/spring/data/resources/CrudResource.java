package br.com.alura.spring.data.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.service.CrudCargoService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/cargo")
public class CrudResource {

	@Autowired
	private CrudCargoService cargoService;

	@PostMapping
	public ResponseEntity<?> salvarCargo(@RequestBody Cargo cargo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cargoService.salvar(cargo));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarCargo(@RequestBody Cargo cargo, @PathVariable(value = "id") final Integer id) throws ObjectNotFoundException{
		return ResponseEntity.ok(cargoService.atualizar(cargo, id));
	}
	
	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(cargoService.visualizar());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> listar(@PathVariable(value = "id") final Integer id) throws ObjectNotFoundException {
		cargoService.deletar(id);
		return ResponseEntity.ok().body(HttpStatus.ACCEPTED);
	}
}
