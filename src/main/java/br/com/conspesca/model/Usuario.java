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
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario")
	private Integer idUsuario;

	private String nome;
	private String email;
	private String login;
	private String senha;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento;

	@OneToMany(mappedBy = "usuario")
	private List<Pesca> pescas;

	public Usuario() {

	}

	public Usuario(Integer idusuario, String nome, String email, String login, String senha, Date dataNascimento) {
		super();
		this.idUsuario = idusuario;
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
	}

	public Integer getIdusuario() {
		return this.idUsuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idUsuario = idusuario;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Pesca> getPescas() {
		return this.pescas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.dataNascimento == null) ? 0 : this.dataNascimento.hashCode());
		result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
		result = prime * result + ((this.idUsuario == null) ? 0 : this.idUsuario.hashCode());
		result = prime * result + ((this.login == null) ? 0 : this.login.hashCode());
		result = prime * result + ((this.nome == null) ? 0 : this.nome.hashCode());
		result = prime * result + ((this.senha == null) ? 0 : this.senha.hashCode());
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
		Usuario other = (Usuario) obj;
		if (this.dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!this.dataNascimento.equals(other.dataNascimento))
			return false;
		if (this.email == null) {
			if (other.email != null)
				return false;
		} else if (!this.email.equals(other.email))
			return false;
		if (this.idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!this.idUsuario.equals(other.idUsuario))
			return false;
		if (this.login == null) {
			if (other.login != null)
				return false;
		} else if (!this.login.equals(other.login))
			return false;
		if (this.nome == null) {
			if (other.nome != null)
				return false;
		} else if (!this.nome.equals(other.nome))
			return false;
		if (this.senha == null) {
			if (other.senha != null)
				return false;
		} else if (!this.senha.equals(other.senha))
			return false;
		return true;
	}

}
