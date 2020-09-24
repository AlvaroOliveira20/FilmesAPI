package br.edu.cesmac.filmeapi.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Filme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFilme;
	@NotEmpty(message = "O nome é obrigatório")
	private String titulo;
	@NotEmpty(message = "Data de lançamento é obrigatório")
	private Date dataLancamento;
	@NotEmpty(message = "Sinopse é obrigatório")
	private String sinopse;
	private Long genero_id;
	@JsonIgnoreProperties("filme")
	@OneToOne(mappedBy = "filme")
	@NotEmpty(message = "É obrigatório informar o gênero do filme")
	private Genero genero;
	@JsonIgnoreProperties("filme")
	@OneToMany(mappedBy = "filme")
	@NotEmpty(message = "É obrigatório informar os atores do filme")
	private Ator ator;

	public Filme(Long idFilme, String titulo, Date dataLancamento, String sinopse, Long genero_id) {
		this.idFilme = idFilme;
		this.titulo = titulo;
		this.dataLancamento = dataLancamento;
		this.sinopse = sinopse;
		this.genero_id = genero_id;

	}

	public Long getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(Long idFilme) {
		this.idFilme = idFilme;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Long getGenero_id() {
		return genero_id;
	}

	public void setGenero_id(Long genero_id) {
		this.genero_id = genero_id;
	}

}
