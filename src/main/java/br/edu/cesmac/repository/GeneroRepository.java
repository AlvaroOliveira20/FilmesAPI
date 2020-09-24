package br.edu.cesmac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.cesmac.filmeapi.domain.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
	List<Genero> findByNome(String nome);
}
