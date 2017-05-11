package br.com.conspesca.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.conspesca.model.Peixe;
import br.com.conspesca.repository.PeixeRepository;

@Stateless
public class PeixeService {

	@Inject
	private PeixeRepository peixeRepository;

	
	public void salvar(Peixe peixe){
		this.peixeRepository.save(peixe);
	}
	
	public Peixe findPeixeByID(int id){
		return this.peixeRepository.find(id);
	}
	
	public void removePeixeByID(int id){
		this.peixeRepository.delete(id);
	}
	
	public List<Peixe> findAllPeixe(){
		return this.peixeRepository.findAll();
	}
	
}
