package br.com.conspesca.mb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.conspesca.model.Peixe;
import br.com.conspesca.service.PeixeService;

@Named
@RequestScoped
public class PeixeMB {
	private List<Peixe> peixes;
	private Peixe peixe;
	private Date data;

	@EJB
	private PeixeService peixeService;

	
	@Inject
	public void init(){
		this.peixes = new ArrayList<>();
		this.peixe = new Peixe();
		
		this.peixe.setEspecie("a");
		this.peixe.setFimPesca(new Date());
		this.peixe.setInicioPesca(new Date());
		this.peixe.setNome("a");
		this.peixe.setPesoMax(2D);
		this.peixe.setTamanhoMax(3D);
		
		this.peixeService.salvar(this.peixe);
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setPeixes(List<Peixe> peixes) {
		this.peixes = peixes;
	}

	public List<Peixe> getPeixes() {

		this.peixes = this.peixeService.findAllPeixe();

		return this.peixes;
	}

	public void setPeixe(Peixe peixe) {
		this.peixe = peixe;
	}

	public Peixe getPeixe() {
		return this.peixe;
	}

	public String salvar() {

		this.peixeService.salvar(this.peixe);

		return "consultapeixe";

	}

	public String criarNovo() {
		this.peixe = new Peixe();
		return "cadastropeixe";
	}

	public String verDetalhe(Peixe peixe) {
		this.peixe = peixe;
		return "editapeixe";
	}

	public String remover(Peixe peixe) {
		this.peixeService.removePeixeByID(peixe.getIdPeixe());
		return "consultapeixe";
	}
}
