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

	public Pescaria(Integer idPescaria, Integer quantidade, Double latitude,
			Double longitude) {
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
		result = prime * result
				+ ((this.idPescaria == null) ? 0 : this.idPescaria.hashCode());
		result = prime * result
				+ ((this.latitude == null) ? 0 : this.latitude.hashCode());
		result = prime * result
				+ ((this.longitude == null) ? 0 : this.longitude.hashCode());
		result = prime * result
				+ ((this.quantidade == null) ? 0 : this.quantidade.hashCode());
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
		Pescaria other = (Pescaria) obj;
		if (this.idPescaria == null) {
			if (other.idPescaria != null)
				return false;
		} else if (!this.idPescaria.equals(other.idPescaria))
			return false;
		if (this.latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!this.latitude.equals(other.latitude))
			return false;
		if (this.longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!this.longitude.equals(other.longitude))
			return false;
		if (this.quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!this.quantidade.equals(other.quantidade))
			return false;
		return true;
	}

}
