package br.com.projetopoo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="departamento")
public class Departamento {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	
	@OneToOne
	@JoinColumn(name="id_gestor")
	private Empregado chefe;

	public Departamento() { }
	
	public Departamento(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Empregado getChefe() {
		return chefe;
	}

	public void setChefe(Empregado chefe) {
		this.chefe = chefe;
	}
}
