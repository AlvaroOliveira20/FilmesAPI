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

import br.edu.cesmac.filmeapi.domain.Genero;
import br.edu.cesmac.filmeapi.service.GeneroService;

@RestController
@RequestMapping("/generos")
public class GeneroResource {
	@Autowired
	private GeneroService generosService;

	@GetMapping(params = "titulo")
	public List<Genero> pesquisarPorNome(@RequestParam String nome) {
		return generosService.perquisarPorNome(nome);
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Genero genero) {
		generosService.salvar(genero);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(genero.getGenero_id())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping
	public void atualizar(@RequestBody Genero genero) {
		generosService.atualizar(genero);
	}

	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable("id") Long idGenero) throws Exception {
		generosService.deletarPorId(idGenero);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Genero> buscarPorId(@PathVariable("id") Long idGenero) throws Exception {
		Genero genero = generosService.buscarPorId(idGenero);
		return ResponseEntity.ok(genero);
	}

}
