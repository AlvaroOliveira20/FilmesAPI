package br.edu.cesmac.filmeapi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import br.edu.cesmac.filmeapi.domain.Ator;
import br.edu.cesmac.filmeapi.service.AtorService;

@RestController
@RequestMapping("/ators")
public class AtorResource {
	@Autowired
	private AtorService atorsService;

	@GetMapping(params = "titulo")
	public List<Ator> pesquisarPorNome(@RequestParam String nome) {
		return atorsService.perquisarPorNome(nome);
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Ator ator) {
		atorsService.salvar(ator);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ator.getIdAtor())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping
	public void atualizar(@RequestBody Ator ator) {
		atorsService.atualizar(ator);
	}

	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable("id") Long idAtor) throws Exception {
		atorsService.deletarPorId(idAtor);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Ator> buscarPorId(@PathVariable("id") Long idAtor) throws Exception {
		Ator ator = atorsService.buscarPorId(idAtor);
		return ResponseEntity.ok(ator);
	}

}