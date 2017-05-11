package br.com.conspesca.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "peixe")
public class Peixe implements Serializable {

	private static final long serialVersionUID = -3720718774076438033L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_peixe")
	private Integer idPeixe;

	private String nome;
	private String especie;
	private Double tamanhoMax;
	private Double pesoMax;

	@Temporal(TemporalType.TIMESTAMP)
	private Date inicioPesca;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fimPesca;

	@OneToMany(mappedBy = "peixe")
	private List<Pescaria> pescaria;


	public Integer getIdPeixe() {
		return this.idPeixe;
	}

	public void setIdPeixe(Integer idPeixe) {
		this.idPeixe = idPeixe;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return this.especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Double getTamanhoMax() {
		return this.tamanhoMax;
	}

	public void setTamanhoMax(Double tamanhoMax) {
		this.tamanhoMax = tamanhoMax;
	}

	public Double getPesoMax() {
		return this.pesoMax;
	}

	public void setPesoMax(Double pesoMax) {
		this.pesoMax = pesoMax;
	}

	public Date getInicioPesca() {
		return this.inicioPesca;
	}

	public void setInicioPesca(Date inicioPesca) {
		this.inicioPesca = inicioPesca;
	}

	public Date getFimPesca() {
		return this.fimPesca;
	}

	public void setFimPesca(Date fimPesca) {
		this.fimPesca = fimPesca;
	}

	public List<Pescaria> getPescaria() {
		return this.pescaria;
	}

	public void setPescaria(List<Pescaria> pescaria) {
		this.pescaria = pescaria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.idPeixe == null) ? 0 : this.idPeixe.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Peixe other = (Peixe) obj;
		if (this.idPeixe == null) {
			if (other.idPeixe != null)
				return false;
		} else if (!this.idPeixe.equals(other.idPeixe))
			return false;
		return true;
	}

	

}
