package br.edu.cesmac.filmeapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Ator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAtor;
	private String nome;
	private String dataNascimento;
	private String sexo;
	private String biografia;
	@JsonIgnoreProperties ("ator" )
	@OneToMany (mappedBy = "ator")
	private Filme filme;
	
	
	public Long getIdAtor() {
		return idAtor;
	}
	public void setIdAtor(Long idAtor) {
		this.idAtor = idAtor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	public Ator(Long idAtor, String nome, String dataNascimento, String sexo, String biografia) {
		super();
		this.idAtor = idAtor;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.biografia = biografia;
	}
}
