package br.com.renato.campanha.modelo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.renato.campanha.modelo.entidades.Cadastro;
import br.com.renato.campanha.modelo.entidades.Campanha;
import br.com.renato.campanha.modelo.repositorios.CadastroRepositorio;
import br.com.renato.campanha.modelo.enumeracoes.CategoriaDeCadastro;

@Service
public class ServicoCadastro {
	
	private Cadastro getCampanhaLogada() {
		
		return null;
	}

	@Autowired private ServicoCadastro ServicoCadastro;
	@Autowired private CadastroRepositorio repositorio;
	public void salvar(Cadastro cadastro){
		cadastro.setSocio(ServicoCadastro.getCampanhaLogada());
		repositorio.save(cadastro);
		}
	

	public Iterable<Cadastro> listar(){
		Cadastro socio = ServicoCadastro.getCampanhaLogada();
		return repositorio.findAllBySocio(socio);
	}
	
	public Cadastro buscar(long id){
		Cadastro socio = ServicoCadastro.getCampanhaLogada();
		return repositorio.findByIdAndSocio(id, socio);
	}
	
	

	public void remover(long id){
		Cadastro cadastro = this.buscar(id);
		if(cadastro!=null) repositorio.delete(cadastro);
	}
	
}
