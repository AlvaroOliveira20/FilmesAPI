package br.edu.cesmac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.cesmac.filmeapi.domain.Ator;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Long> {
	List<Ator> findByNome(String nome);
}
