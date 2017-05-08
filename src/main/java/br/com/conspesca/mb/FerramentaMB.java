package br.com.conspesca.mb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.conspesca.model.Ferramenta;
import br.com.conspesca.service.FerramentaService;

@Named
@RequestScoped
public class FerramentaMB {
	private List<Ferramenta> ferramentas;
	private Ferramenta ferramenta;
	private Date data;

	private FerramentaService ferramentaService;

	public FerramentaMB() {
		this.ferramentas = new ArrayList<>();
		this.ferramenta = new Ferramenta();
		this.ferramentaService = new FerramentaService();
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
		
		this.ferramentas = this.ferramentaService.findAllFerramenta();
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
