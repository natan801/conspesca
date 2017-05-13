package br.com.conspesca.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pesca implements Serializable {

	private static final long serialVersionUID = 356497015054603327L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pesca")
	private Integer idPesca;
	private Calendar data;
	private Calendar duracao;
	private String observacao;

	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "ferramenta_id", referencedColumnName = "id_ferramenta")
	private Ferramenta ferramenta;

	@OneToMany(mappedBy = "pesca", cascade = CascadeType.ALL)
	private List<Pescaria> pescarias;

	public Pesca() {
	}

	public Pesca(Integer idPesca, Calendar data, Calendar duracao, String observacao) {
		super();
		this.idPesca = idPesca;
		this.data = data;
		this.duracao = duracao;
		this.observacao = observacao;
	}

	public Integer getIdPesca() {
		return this.idPesca;
	}

	public void setIdPesca(Integer idPesca) {
		this.idPesca = idPesca;
	}

	public Calendar getData() {
		return this.data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Calendar getDuracao() {
		return this.duracao;
	}

	public void setDuracao(Calendar duracao) {
		this.duracao = duracao;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Ferramenta getFerramenta() {
		return this.ferramenta;
	}

	public void setFerramenta(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
	}

	public List<Pescaria> getPescarias() {
		return this.pescarias;
	}

	public void setPescarias(List<Pescaria> pescarias) {
		this.pescarias = pescarias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPesca == null) ? 0 : idPesca.hashCode());
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
		Pesca other = (Pesca) obj;
		if (idPesca == null) {
			if (other.idPesca != null)
				return false;
		} else if (!idPesca.equals(other.idPesca))
			return false;
		return true;
	}

}
