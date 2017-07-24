package br.com.renato.campanha.modelo.servicos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.renato.campanha.modelo.entidades.Torcedor;
import br.com.renato.campanha.modelo.entidades.Campanha;
import br.com.renato.campanha.modelo.repositorios.SocioTorcedorRepositorio;

@Service
public class ServicoSocioTorcedor {

	@Autowired private ServicoCampanha servicoCampanha;
	@Autowired private SocioTorcedorRepositorio repositorio;

	public void salvar(Torcedor torcedor){
		torcedor.setSocio(servicoCampanha.getsocioTorcedorLogado());
		repositorio.save(torcedor);
	}
	
	public Iterable<Torcedor> listar(){
		Campanha socio = servicoCampanha.getsocioTorcedorLogado();
		return repositorio.findAllBySocio(socio);
	}
	
	public Torcedor buscar(long id){
		Campanha socio = servicoCampanha.getsocioTorcedorLogado();
		return repositorio.findByIdAndSocio(id, socio);
	}
	
	public void remover(long id){
		Torcedor torcedor = this.buscar(id);
		if(torcedor!=null) repositorio.delete(torcedor);
	}

	public List<String> listarNomesSocioTorcedoresDisponiveis() {
		List<Torcedor> torcedores = repositorio.findAll();
		
		List<String> nomesTorcedores = torcedores.stream().map((cadastros)->{
			return cadastros.getNome();
		}).sorted().collect(Collectors.toList());
		
		return nomesTorcedores;
	}
	
}
