package br.com.conspesca.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pescaria")
public class Pescaria implements Serializable {

	private static final long serialVersionUID = 582183676133849464L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pescaria")
	private Integer idPescaria;

	private Integer quantidade;
	private Double latitude;
	private Double longitude;

	@ManyToOne
	@JoinColumn(name = "pesca_id")
	private Pesca pesca;

	@ManyToOne
	@JoinColumn(name = "peixe_id")
	private Peixe peixe;

	@ManyToOne
	@JoinColumn(name = "local_id")
	private Local local;

	public Pescaria() {
	}

	public Pescaria(Integer idPescaria, Integer quantidade, Double latitude, Double longitude) {
		super();
		this.idPescaria = idPescaria;
		this.quantidade = quantidade;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Integer getIdPescaria() {
		return this.idPescaria;
	}

	public void setIdPescaria(Integer idPescaria) {
		this.idPescaria = idPescaria;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Pesca getPesca() {
		return this.pesca;
	}

	public void setPesca(Pesca pesca) {
		this.pesca = pesca;
	}

	public Peixe getPeixe() {
		return this.peixe;
	}

	public void setPeixe(Peixe peixe) {
		this.peixe = peixe;
	}

	public Local getLocal() {
		return this.local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPescaria == null) ? 0 : idPescaria.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pescaria other = (Pescaria) obj;
		if (idPescaria == null) {
			if (other.idPescaria != null)
				return false;
		} else if (!idPescaria.equals(other.idPescaria))
			return false;
		return true;
	}

}
