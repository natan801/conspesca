package br.com.conspesca.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.conspesca.model.Pescaria;
import br.com.conspesca.repository.PescariaRepository;

@Stateless
public class PescariaService {

	@Inject
	private PescariaRepository pescariaRepository;

	public List<Pescaria> findAllPescaria(){
		return this.pescariaRepository.findAll();
	}
	
}
