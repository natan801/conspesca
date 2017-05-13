package br.com.conspesca.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Local implements Serializable {

	private static final long serialVersionUID = -215723937531032509L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_local")
	private Integer idLocal;

	private String nome;
	private String descricao;

	@OneToMany(mappedBy = "local")
	private List<Pescaria> pescaria;

	public Local() {
	}

	public Local(Integer idLocal, String nome, String descricao) {
		super();
		this.idLocal = idLocal;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getIdLocal() {
		return this.idLocal;
	}

	public void setIdLocal(Integer idLocal) {
		this.idLocal = idLocal;
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
		result = prime * result + ((idLocal == null) ? 0 : idLocal.hashCode());
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
		Local other = (Local) obj;
		if (idLocal == null) {
			if (other.idLocal != null)
				return false;
		} else if (!idLocal.equals(other.idLocal))
			return false;
		return true;
	}

}
