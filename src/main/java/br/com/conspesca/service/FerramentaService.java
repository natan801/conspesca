package br.com.conspesca.service;

import java.util.List;

import br.com.conspesca.model.Ferramenta;
import br.com.conspesca.repository.FerramentaRepository;

public class FerramentaService {
	FerramentaRepository ferramentaRepository = new FerramentaRepository();

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
