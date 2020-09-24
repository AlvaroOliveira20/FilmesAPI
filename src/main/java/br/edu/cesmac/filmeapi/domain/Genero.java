package br.edu.cesmac.filmeapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Genero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long genero_id;
	@NotEmpty(message = "O nome é obrigatório")
	private String nome;
	@NotEmpty(message = "A descrição é obrigatória")
	private String descricao;
	
	
	public Genero(Long genero_id, String nome, String descricao) {
		super();
		this.genero_id = genero_id;
		this.nome = nome;
		this.descricao = descricao;
	}
	public Long getGenero_id() {
		return genero_id;
	}
	public void setGenero_id(Long genero_id) {
		this.genero_id = genero_id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
