package br.com.conspesca.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.primefaces.model.map.Marker;

import br.com.conspesca.model.Peixe;
import br.com.conspesca.service.PeixeService;
import br.com.conspesca.service.PescariaService;
import br.com.conspesca.utils.CorUtil;

@Named
@ViewScoped
public class PesquisaPrincipalMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private MapModel circleModel;

	@EJB
	private PescariaService pescariaService;

	@EJB
	private PeixeService peixeService;

	@PostConstruct
	public void init() {

		this.circleModel = new DefaultMapModel();

		Peixe peixe = peixeService.findPeixeByID(2);
		List<Circle> circulos = this.getListaCirculos(this.pescariaService.getListaCoordenadasByPeixe(peixe), peixe);
		if (!circulos.isEmpty()) {
			for (Circle circulo : circulos) {
				this.circleModel.addOverlay(circulo);

			}
		}
	}

	public MapModel getCircleModel() {
		return this.circleModel;
	}

	public List<Circle> getListaCirculos(List<LatLng> coordenadas, Peixe peixe) {
		List<Circle> listaCirculos = new ArrayList<Circle>();
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
}
