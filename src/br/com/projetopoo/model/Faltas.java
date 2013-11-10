package br.com.projetopoo.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="faltas")
public class Faltas {
	
	@OneToOne
	@JoinColumn(name="id_empregado")
	private Empregado empregado;
	
	@Id
	@Column(name="data_falta")
	private Calendar dataFalta;
	
	private Boolean abonada;

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

	public Calendar getDataFalta() {
		return dataFalta;
	}

	public void setDataFalta(Calendar dataFalta) {
		this.dataFalta = dataFalta;
	}

	public Boolean getAbonada() {
		return abonada;
	}

	public void setAbonada(Boolean abonada) {
		this.abonada = abonada;
	}
	

}



