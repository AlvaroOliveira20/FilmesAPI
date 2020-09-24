package br.edu.cesmac.filmeapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.cesmac.filmeapi.domain.Ator;
import br.edu.cesmac.repository.AtorRepository;

@Service
public class AtorService {

	@Autowired
	private AtorRepository atoresRepository;

	public List<Ator> perquisarPorNome(String nome) {
		return atoresRepository.findByNome(nome);
	}

	public Ator salvar(Ator atore) {
		Ator atoreCriada = atoresRepository.save(atore);
		return atoreCriada;
	}

	public Ator atualizar(Ator atore) {
		Ator atoreAtualizada = atoresRepository.save(atore);
		return atoreAtualizada;
	}

	public void deletarPorId(Long id) throws Exception {
		Ator atoreExclusao = atoresRepository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
		atoresRepository.deleteById(id);
	}

	public Ator buscarPorId(Long id) throws Exception {
		return atoresRepository.findById(id).orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
	}

	public List<Ator> listar() {
		return atoresRepository.findAll();
	}

}