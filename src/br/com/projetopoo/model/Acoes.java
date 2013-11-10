package br.com.projetopoo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="acoes")
public class Acoes {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_empregado")
	private Empregado empregado;
	
	private Date dataInicio;

	private Date dataFim;

	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="id_gestor")
	private Empregado gestor;
	
	private Character tipoAcao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicial) {
		this.dataInicio = dataInicial;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Empregado getGestor() {
		return gestor;
	}

	public void setGestor(Empregado gestor) {
		this.gestor = gestor;
	}

	public Character getTipoAcao() {
		return tipoAcao;
	}

	public void setTipoAcao(Character tipoAcao) {
		this.tipoAcao = tipoAcao;
	}
}