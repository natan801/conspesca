package br.com.conspesca.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.LatLng;

import br.com.conspesca.model.Ferramenta;
import br.com.conspesca.model.Peixe;
import br.com.conspesca.model.Pesca;
import br.com.conspesca.model.Pescaria;
import br.com.conspesca.service.FerramentaService;
import br.com.conspesca.service.PeixeService;
import br.com.conspesca.service.PescaService;
import br.com.conspesca.service.UsuarioService;

@Named
@ViewScoped
public class PescaMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pesca pesca;
	private List<Pesca> pescas;

	@EJB
	private PescaService pescaService;

	private Ferramenta ferramenta;
	private List<Ferramenta> listaFerramentas;

	@EJB
	private FerramentaService ferramentaService;

	private List<Peixe> peixes;

	@EJB
	private PeixeService peixeService;

	@EJB
	private UsuarioService usuarioService;

	private Pescaria pescaria;
	private List<Pescaria> pescarias;
	private List<Pescaria> pescariasAdicionadas;

	@Inject
	public void init() {
		this.pesca = new Pesca();
		this.pescaria = new Pescaria();
		this.pescariasAdicionadas = new ArrayList<>();

		this.listaFerramentas = this.ferramentaService.findAllFerramenta();
		this.peixes = this.peixeService.findAllPeixe();
		this.pescas = this.pescaService.findAllPesca();
	}

	public Pesca getPesca() {
		return this.pesca;
	}

	public void setPesca(Pesca pesca) {
		this.pesca = pesca;
	}

	public List<Pesca> getPescas() {
		return this.pescas;
	}

	public Ferramenta getFerramenta() {
		return this.ferramenta;
	}

	public void setFerramenta(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
	}

	public void setPescas(List<Pesca> pescas) {
		this.pescas = pescas;
	}

	public List<Ferramenta> getListaFerramentas() {

		return this.listaFerramentas;
	}

	public void setListaFerramentas(List<Ferramenta> listaFerramentas) {
		this.listaFerramentas = listaFerramentas;
	}

	public List<Pescaria> getPescarias() {
		return this.pescarias;
	}

	public void setPescarias(List<Pescaria> pescarias) {
		this.pescarias = pescarias;
	}

	public Pescaria getPescaria() {
		return this.pescaria;
	}

	public void setPescaria(Pescaria pescaria) {
		this.pescaria = pescaria;
	}

	public List<Peixe> getPeixes() {
		return this.peixes;
	}

	public List<Pescaria> getPescariasAdicionadas() {
		return this.pescariasAdicionadas;
	}

	public void setPescariasAdicionadas(List<Pescaria> pescariasAdicionadas) {
		this.pescariasAdicionadas = pescariasAdicionadas;
	}

	public String salvarPesca() {
		
		this.pesca.setUsuario(this.usuarioService.findUsuarioByID(1));
		this.pesca.setFerramenta(this.ferramenta);
		this.pesca.setPescarias(this.pescariasAdicionadas);
		this.pescaService.salvar(this.pesca);

		return "consultapesca";

	}

	public void selecionaCoordenada(PointSelectEvent event) {

		if (this.pescaria == null) {
			this.pescaria = new Pescaria();
		}

		LatLng latLng = event.getLatLng();

		this.pescaria.setLatitude(latLng.getLat());
		this.pescaria.setLongitude(latLng.getLng());
	}

	public void adicionaPescaria() {

		this.pescaria.setPesca(this.pesca);
		this.pescariasAdicionadas.add(this.pescaria);

		this.pescaria = new Pescaria();
	}

}
