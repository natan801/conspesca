package br.com.conspesca.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.Circle;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;

import br.com.conspesca.model.Peixe;
import br.com.conspesca.model.Pescaria;
import br.com.conspesca.service.PeixeService;
import br.com.conspesca.service.PescariaService;
import br.com.conspesca.utils.CorUtil;

@Named
@ViewScoped
public class PesquisaPrincipalMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private MapModel circleModel;

	private Integer pesquisaPescaria;

	@EJB
	private PescariaService pescariaService;

	@EJB
	private PeixeService peixeService;

	private List<Circle> circulos;

	
	
	@PostConstruct
	public void init() {

		this.circleModel = new DefaultMapModel();
		this.circulos = new ArrayList<>();
		
	}

	

	public Integer getPesquisaPescaria() {
		return this.pesquisaPescaria;
	}



	public void setPesquisaPescaria(Integer pesquisaPescaria) {
		this.pesquisaPescaria = pesquisaPescaria;
	}



	public List<Peixe> findPeixes(String query) {
		return this.peixeService.findAllPeixe();
	}
	
	
	public void onPeixeSelect(){
		List<Pescaria> pescarias = this.pescariaService.findPescariasByPeixe(this.pesquisaPescaria);
		
		// chamar metodo pra atualizar os dados da  tela
		List<LatLng> listaCoordenadas = this.pescariaService.getListaCoordenadas(pescarias);
		
		this.circulos = this.getListaCirculos(listaCoordenadas);
		if (!this.circulos.isEmpty()) {
			for (Circle circulo : this.circulos) {
				this.circleModel.addOverlay(circulo);
			}
		}

		
	}

	public MapModel getCircleModel() {
		return this.circleModel;
	}

	public List<Circle> getListaCirculos(List<LatLng> coordenadas) {
		List<Circle> listaCirculos = new ArrayList<>();
		CorUtil corUtil = new CorUtil();
		for (LatLng coordenada : coordenadas) {
			Circle circulo = new Circle(coordenada, 100);
			String cor = corUtil.getCor();
			circulo.setStrokeColor(cor);
			circulo.setFillColor(cor);

			listaCirculos.add(circulo);

		}

		return listaCirculos;
	}

	
	
	public List<Circle> getListaCirculos(List<LatLng> coordenadas, Peixe peixe) {
		List<Circle> listaCirculos = new ArrayList<>();
		CorUtil corUtil = new CorUtil();
		for (LatLng coordenada : coordenadas) {
			Circle circulo = new Circle(coordenada, 100);
			String cor = corUtil.getCor();
			circulo.setStrokeColor(cor);
			circulo.setFillColor(cor);

			circulo.setData(peixe);
			listaCirculos.add(circulo);

		}

		return listaCirculos;
	}

	
	
	
	
	public void onCircleSelect(OverlaySelectEvent event) {
		Circle circulo = (Circle) event.getOverlay();
		Peixe peixeSelecionado = (Peixe) circulo.getData();
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Circulo selecionado", peixeSelecionado.getNome()));

	}
	
	public List<Circle> getCirculos() {
		return this.circulos;
	}
}
