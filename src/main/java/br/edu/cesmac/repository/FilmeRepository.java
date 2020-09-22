package br.edu.cesmac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.cesmac.filmeapi.domain.Filme;



@Repository
public interface FilmeRepository extends JpaRepository<Filme , Long> {
 List<Filme> findByNome(String titulo) ;
}
