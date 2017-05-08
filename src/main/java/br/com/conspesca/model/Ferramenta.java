package br.com.conspesca.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ferramenta")
public class Ferramenta implements Serializable{

	private static final long serialVersionUID = -1850680242163092547L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_ferramenta")
	private Integer idFerramenta;

	private String nome;
	private String descricao;

	@OneToMany(mappedBy = "ferramenta")
	private List<Pesca> pescas;

	public Ferramenta() {

	}

	public Ferramenta(Integer idFerramenta, String nome, String descricao) {
		super();
		this.idFerramenta = idFerramenta;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getIdFerramenta() {
		return this.idFerramenta;
	}

	public void setIdFerramenta(Integer idFerramenta) {
		this.idFerramenta = idFerramenta;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Pesca> getPescas() {
		return this.pescas;
	}

	public void setPescas(List<Pesca> pescas) {
		this.pescas = pescas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.descricao == null) ? 0 : this.descricao.hashCode());
		result = prime
				* result
				+ ((this.idFerramenta == null) ? 0 : this.idFerramenta
						.hashCode());
		result = prime * result
				+ ((this.nome == null) ? 0 : this.nome.hashCode());
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
		Ferramenta other = (Ferramenta) obj;
		if (this.descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!this.descricao.equals(other.descricao))
			return false;
		if (this.idFerramenta == null) {
			if (other.idFerramenta != null)
				return false;
		} else if (!this.idFerramenta.equals(other.idFerramenta))
			return false;
		if (this.nome == null) {
			if (other.nome != null)
				return false;
		} else if (!this.nome.equals(other.nome))
			return false;
		return true;
	}

}
