package br.com.conspesca.service;

import java.util.List;

import br.com.conspesca.model.Pesca;
import br.com.conspesca.repository.PescaRepository;

public class PescaService {
	PescaRepository pescaRepository = new PescaRepository();

	public void salvar(Pesca pesca){
		this.pescaRepository.save(pesca);
	}
	
	public Pesca findPescaByID(int id){
		return this.pescaRepository.find(id);
	}
	
	public List<Pesca> findAllPesca(){
		return this.pescaRepository.findAll();
	}
}
