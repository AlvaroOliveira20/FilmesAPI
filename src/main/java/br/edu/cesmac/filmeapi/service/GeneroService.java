package br.edu.cesmac.filmeapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.cesmac.filmeapi.domain.Genero;
import br.edu.cesmac.repository.GeneroRepository;

@Service
public class GeneroService {

	@Autowired
	private GeneroRepository generosRepository;

	public List<Genero> perquisarPorNome(String nome) {
		return generosRepository.findByNome(nome);
	}

	public Genero salvar(Genero genero) {
		Genero generoCriada = generosRepository.save(genero);
		return generoCriada;
	}

	public Genero atualizar(Genero genero) {
		Genero generoAtualizada = generosRepository.save(genero);
		return generoAtualizada;
	}

	public void deletarPorId(Long id) throws Exception {
		Genero generoExclusao = generosRepository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
		generosRepository.deleteById(id);
	}

	public Genero buscarPorId(Long id) throws Exception {
		return generosRepository.findById(id).orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
	}

	public List<Genero> listar() {
		return generosRepository.findAll();
	}

}