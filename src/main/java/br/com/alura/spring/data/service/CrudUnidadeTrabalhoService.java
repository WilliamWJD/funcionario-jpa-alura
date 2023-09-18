package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Unidade;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrudUnidadeTrabalhoService {

    private final UnidadeRepository unidadeRepository;

    public CrudUnidadeTrabalhoService(UnidadeRepository unidadeRepository){
        this.unidadeRepository = unidadeRepository;
    }

    public Unidade salvarUnidadeDeTrabalho(Unidade unidade){
        // salva uma unidade de trabalho
        return unidadeRepository.save(unidade);
    }

    public List<Unidade> listarUnidadesDeTrabalho(){
        return (List<Unidade>) unidadeRepository.findAll();
    }

    public Unidade buscarUnidadeDeTrabalhoPorId(final Integer id){
        return unidadeRepository.findById(id).orElseThrow(()->new RuntimeException("Erro: Unidade de trabalho não encontrado"));
    }

    public Unidade atualizarUnidadeDeTrabalho(final Integer id, Unidade unidade){
         Unidade und = buscarUnidadeDeTrabalhoPorId(id);

         und.setEndereco(unidade.getEndereco());
         und.setDescricao(unidade.getDescricao());

         return salvarUnidadeDeTrabalho(und);
    }

    public void deletaUnidadeDeTrabalho(final Integer id){
        buscarUnidadeDeTrabalhoPorId(id);

        unidadeRepository.deleteById(id);
    }
}
