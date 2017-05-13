package br.com.conspesca.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.primefaces.model.map.LatLng;

import br.com.conspesca.model.Ferramenta;
import br.com.conspesca.model.Peixe;
import br.com.conspesca.model.Pescaria;
import br.com.conspesca.repository.PescariaRepository;

@Stateless
public class PescariaService {

	@Inject
	private PescariaRepository pescariaRepository;

	public List<Pescaria> findAllPescaria() {
		return this.pescariaRepository.findAll();
	}

	public List<Pescaria> findByPeixe(Peixe peixe) {
		return this.pescariaRepository.findByPeixe(peixe);
	}

	public List<Pescaria> findByFerramenta(Ferramenta ferramenta) {
		return this.pescariaRepository.findByFerramenta(ferramenta);
	}

	public List<LatLng> getListaCoordenadas() {

		List<Pescaria> listaPescaria = this.findAllPescaria();

		List<LatLng> coordenadas = new ArrayList<LatLng>();

		for (Pescaria pescaria : listaPescaria) {
			LatLng coordenada = new LatLng(pescaria.getLatitude(), pescaria.getLongitude());
			coordenadas.add(coordenada);
		}

		return coordenadas;
	}

	public List<LatLng> getListaCoordenadasByPeixe(Peixe peixe) {

		List<Pescaria> listaPescaria = this.findByPeixe(peixe);

		List<LatLng> coordenadas = new ArrayList<LatLng>();

		for (Pescaria pescaria : listaPescaria) {
			LatLng coordenada = new LatLng(pescaria.getLatitude(), pescaria.getLongitude());
			coordenadas.add(coordenada);
		}

		return coordenadas;
	}

	public List<LatLng> getListaCoordenadasByFerramenta(Ferramenta ferramenta) {

		List<Pescaria> listaPescaria = this.findByFerramenta(ferramenta);

		List<LatLng> coordenadas = new ArrayList<LatLng>();

		for (Pescaria pescaria : listaPescaria) {
			LatLng coordenada = new LatLng(pescaria.getLatitude(), pescaria.getLongitude());
			coordenadas.add(coordenada);
		}

		return coordenadas;
	}

}
