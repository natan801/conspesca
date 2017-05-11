package br.com.conspesca.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.conspesca.model.Ferramenta;
import br.com.conspesca.repository.FerramentaRepository;

@Stateless
public class FerramentaService {
	
	@Inject
	private FerramentaRepository ferramentaRepository;

	public void salvar(Ferramenta ferramenta){
		this.ferramentaRepository.save(ferramenta);
	}
	
	public Ferramenta findFerramentaByID(int id){
		return this.ferramentaRepository.find(id);
	}
	
	public void removeFerramentaByID(int id){
		this.ferramentaRepository.delete(id);
	}
	
	public List<Ferramenta> findAllFerramenta(){
		return this.ferramentaRepository.findAll();
	}
}
