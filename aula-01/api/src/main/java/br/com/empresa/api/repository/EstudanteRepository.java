package br.com.empresa.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.empresa.api.entity.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long>{

	Page<Estudante> findAllByOrderByNomeAsc(Pageable pageable);
	

	Page<Estudante> findAllByOrderByNomeDesc(Pageable pageable);
	
	List<Estudante> findByAvaliacaoCursosEstudanteIsNull();

	@Query("select e from Estudante e where e.id = :id")
//	@EntityGraph(attributePaths = {"livros", "endereco"})
	Optional<Estudante> findById(@Param("id") Long id);
}
