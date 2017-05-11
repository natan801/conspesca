package br.com.conspesca.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.conspesca.model.Pesca;
import br.com.conspesca.repository.PescaRepository;

@Stateless
public class PescaService {
	
	@Inject
	private PescaRepository pescaRepository;

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
