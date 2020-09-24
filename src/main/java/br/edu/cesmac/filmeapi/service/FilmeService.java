package br.edu.cesmac.filmeapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.cesmac.filmeapi.domain.Filme;
import br.edu.cesmac.repository.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository filmesRepository;

	public List<Filme> perquisarPorNome(String titulo) {
		return filmesRepository.findByNome(titulo);
	}

	public Filme salvar(Filme filme) {
		Filme filmeCriada = filmesRepository.save(filme);
		return filmeCriada;
	}

	public Filme atualizar(Filme filme) {
		Filme filmeAtualizada = filmesRepository.save(filme);
		return filmeAtualizada;
	}

	public void deletarPorId(Long id) throws Exception {
		Filme filmeExclusao = filmesRepository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
		filmesRepository.deleteById(id);
	}

	public Filme buscarPorId(Long id) throws Exception {
		return filmesRepository.findById(id).orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
	}

	public List<Filme> listar() {
		return filmesRepository.findAll();
	}

}