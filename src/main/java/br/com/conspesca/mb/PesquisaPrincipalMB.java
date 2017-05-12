package br.com.conspesca.mb;

import java.io.Serializable;
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

import br.com.conspesca.model.Pescaria;
import br.com.conspesca.service.PescariaService;

@Named
@ViewScoped
public class PesquisaPrincipalMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private MapModel circleModel;
	
	private Pescaria pescaria;
	private List<Pescaria> pescarias;
	
	@EJB
	private PescariaService pescariaService;
	
	
	@PostConstruct
	public void init() {

		this.circleModel = new DefaultMapModel();
		this.pescarias = this.pescariaService.findAllPescaria();
		
		//Coordenadas Compartilhadas
		
		this.pescaria = this.pescarias.get(0);
		LatLng coord1 = new LatLng(this.pescaria.getLatitude(),this.pescaria.getLongitude());
		
		this.pescaria = this.pescarias.get(1);
		
		LatLng coord4 = new LatLng(this.pescaria.getLatitude(),this.pescaria.getLongitude());
		
		this.pescaria = this.pescarias.get(2);
		
		LatLng coord5 = new LatLng(this.pescaria.getLatitude(),this.pescaria.getLongitude());
		
		
		
		// Circulos
		Circle circle1 = new Circle(coord1, 500);
		circle1.setStrokeColor("#d93c3c");
		circle1.setFillColor("#d93c3c");
		circle1.setFillOpacity(0.5);

		Circle circle2 = new Circle(coord4, 300);
		circle2.setStrokeColor("#00ff00");
		circle2.setFillColor("#00ff00");
		circle2.setStrokeOpacity(0.7);
		circle2.setFillOpacity(0.7);

		Circle circle3 = new Circle(coord5, 200);
		circle3.setStrokeColor("#003f01");
		circle3.setFillColor("#00ff01");
		circle3.setStrokeOpacity(0.7);
		circle3.setFillOpacity(0.7);

		
		 
		this.circleModel.addOverlay(circle1);
		this.circleModel.addOverlay(circle2);
		this.circleModel.addOverlay(circle3);
	}

	public MapModel getCircleModel() {
		return this.circleModel;
	}

	public void onCircleSelect(OverlaySelectEvent event) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Circle Selected", null));
	}
}
