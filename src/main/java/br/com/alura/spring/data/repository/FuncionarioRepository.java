package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.orm.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>, JpaSpecificationExecutor<Funcionario> {
    List<Funcionario> findByNome(String nome);

    @Query("SELECT f FROM Funcionario f WHERE f.nome LIKE %:nome% AND f.salario = :salario AND f.dataContratacao = :data")
    List<Funcionario> buscarPorNomeDataContratacaoESalarioMaior(String nome, LocalDate data, BigDecimal salario);

    @Query(value = "SELECT * FROM funcionarios f WHERE f.data_contratacao >= :data", nativeQuery = true)
    List<Funcionario> buscarFuncionariosComDataSuperior(LocalDate data);
}
