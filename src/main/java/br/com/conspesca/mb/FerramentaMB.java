package br.com.conspesca.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.conspesca.model.Ferramenta;
import br.com.conspesca.service.FerramentaService;

@Named
@ViewScoped
public class FerramentaMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Ferramenta ferramenta;
	private List<Ferramenta> ferramentas;
	private Date data;

	@EJB
	private FerramentaService ferramentaService;

	@Inject
	public void init() {
		this.ferramentas = new ArrayList<>();
		this.ferramenta = new Ferramenta();

		this.ferramentas = this.ferramentaService.findAllFerramenta();
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setFerramentas(List<Ferramenta> ferramentas) {
		this.ferramentas = ferramentas;
	}

	public List<Ferramenta> getFerramentas() {
		return this.ferramentas;
	}

	public void setFerramenta(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
	}

	public Ferramenta getFerramenta() {
		return this.ferramenta;
	}

	public String salvar() {

		this.ferramentaService.salvar(this.ferramenta);

		return "consultaferramenta";

	}

	public String criarNovo() {
		this.ferramenta = new Ferramenta();
		return "cadastroferramenta";
	}

	public String verDetalhe(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
		return "editaferramenta";
	}

	public String remover(Ferramenta ferramenta) {
		this.ferramentaService.removeFerramentaByID(ferramenta.getIdFerramenta());
		return "consultaferramenta";
	}
}
