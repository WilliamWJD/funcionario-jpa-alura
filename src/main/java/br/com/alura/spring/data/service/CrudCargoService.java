package br.com.alura.spring.data.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CrudCargoService {

	private final CargoRepository cargoRepository;

	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public Cargo salvar(Cargo cargo) {
		return cargoRepository.save(cargo);
	}

	public Cargo atualizar(Cargo cargo, Integer id) throws ObjectNotFoundException {
		Optional<Cargo> carg = cargoRepository.findById(id);
		if (!carg.isPresent()) {
			throw new ObjectNotFoundException("erro");
		}
		carg.get().setDescricao(cargo.getDescricao());
		return salvar(carg.get());
	}
	
	public List<Cargo> visualizar() {
		return (List<Cargo>) cargoRepository.findAll();
	}
	
	public void deletar(Integer id) throws ObjectNotFoundException {
		Optional<Cargo> carg = cargoRepository.findById(id);
		if (!carg.isPresent()) {
			throw new ObjectNotFoundException("erro");
		}
		
		cargoRepository.deleteById(carg.get().getId());
	}

	public Cargo buscarCargoPorId(final Integer id){
		return cargoRepository.findById(id).orElseThrow(()->new RuntimeException("Erro: cargo não encontrado"));
	}
}
