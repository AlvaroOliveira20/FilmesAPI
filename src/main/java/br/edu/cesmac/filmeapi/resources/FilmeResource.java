package br.edu.cesmac.filmeapi.resources;

import java.net.URI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.cesmac.filmeapi.domain.Filme;
import br.edu.cesmac.filmeapi.service.FilmeService;
import br.edu.cesmac.repository.FilmeRepository;

@RestController
@RequestMapping("/filmes")
public class FilmeResource {
	@Autowired
	private FilmeService filmesService;
	
	@GetMapping(params = "titulo")
	public List<Filme> pesquisarPorNome(@RequestParam String titulo) {
		return filmesService.perquisarPorNome(titulo);
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Filme filme) {
		filmesService.salvar(filme);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(filme.getIdFilme())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping
	public void atualizar(@RequestBody Filme filme) {
		filmesService.atualizar(filme);
	}

	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable("id") Long idFilme) throws Exception {
		filmesService.deletarPorId(idFilme);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Filme> buscarPorId(@PathVariable("id") Long idFilme) throws Exception {
		Filme filme = filmesService.buscarPorId(idFilme);
		return ResponseEntity.ok(filme);
	}

}
