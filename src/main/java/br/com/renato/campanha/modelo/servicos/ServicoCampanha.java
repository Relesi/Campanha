package br.com.renato.campanha.modelo.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.renato.campanha.modelo.entidades.Campanha;
import br.com.renato.campanha.modelo.repositorios.CampanhaRepositorio;

@Service
public class ServicoCampanha {

	@Autowired private CampanhaRepositorio campanhaRepositorio;
	
	public Campanha getsocioTorcedorLogado(){
		Authentication autenticado = SecurityContextHolder.getContext().getAuthentication();
		if ( autenticado == null ) throw new AuthenticationCredentialsNotFoundException("Usuario nao logado");
		
		UserDetails usuarioLogado = (UserDetails) autenticado.getPrincipal();
		return campanhaRepositorio.findOneByLogin( usuarioLogado.getUsername() );
	}

	public List<Campanha> listarCampanhasQueContem(String nomeTorcedor) {
		return campanhaRepositorio.listarCampanhasPorNomeTorcedor(nomeTorcedor);
	}
	
}
