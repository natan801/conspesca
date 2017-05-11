package br.com.conspesca.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
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

@Named
@RequestScoped
public class PescaMB implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Pesca pesca;
	private List<Pesca> pescas;

	private PescaService pescaService;

	private Ferramenta ferramenta;
	private List<Ferramenta> listaFerramentas = new ArrayList<>();
	private FerramentaService ferramentaService = new FerramentaService();

	private List<Peixe> peixes;
	private PeixeService peixeService;

	private Pescaria pescaria;
	private List<Pescaria> pescarias;
	private List<Pescaria> pescariasAdicionadas = new ArrayList<>();

	private String latMap;
	private String longMap;

	public String getLatMap() {
		return this.latMap;
	}

	public void setLatMap(String latMap) {
		this.latMap = latMap;
	}

	public String getLongMap() {
		return this.longMap;
	}

	public void setLongMap(String longMap) {
		this.longMap = longMap;
	}

	
	public PescaMB() {
		this.pesca = new Pesca();
		this.pescaria = new Pescaria();
		this.pescas = new ArrayList<>();
		this.pescaService = new PescaService();
		this.listaFerramentas = this.ferramentaService.findAllFerramenta();
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

	public PescaService getPescaService() {
		return this.pescaService;
	}

	public void setPescaService(PescaService pescaService) {
		this.pescaService = pescaService;
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
		if (this.peixes == null) {
			this.peixes = this.getPeixeService().findAllPeixe();
		}
		return this.peixes;
	}

	public PeixeService getPeixeService() {
		if (this.peixeService == null) {
			this.peixeService = new PeixeService();
		}
		return this.peixeService;
	}

	public List<Pescaria> getPescariasAdicionadas() {
		return this.pescariasAdicionadas;
	}

	public void setPescariasAdicionadas(List<Pescaria> pescariasAdicionadas) {
		this.pescariasAdicionadas = pescariasAdicionadas;
	}

	public String salvarPesca() {
		this.pesca.setPescarias(this.pescariasAdicionadas);
		this.pescaService.salvar(this.pesca);
		return "consultapesca";

	}
	

	public void selecionaCoordenada(PointSelectEvent event) {
		LatLng latLng = event.getLatLng();

		this.pescaria.setLatitude( latLng.getLat());
		this.pescaria.setLongitude(latLng.getLng());
	}

	public void adicionaPescaria() {
		this.pescariasAdicionadas.add(this.pescaria);
		this.pescaria =  new Pescaria();
	}

}
