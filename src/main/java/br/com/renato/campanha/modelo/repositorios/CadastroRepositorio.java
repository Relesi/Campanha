package br.com.renato.campanha.modelo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.renato.campanha.modelo.entidades.Cadastro;
import br.com.renato.campanha.modelo.entidades.Campanha;

@Repository
public interface CadastroRepositorio extends CrudRepository<Cadastro, Long> {
	
	public List<Cadastro> findAllByDono(Cadastro socio);
	
	public Cadastro findByIdAndDono(Long id,Cadastro socio);

	public Iterable<Cadastro> findAllBySocio(Cadastro socio);

	public Cadastro findByIdAndSocio(long id, Cadastro socio);
	
}
