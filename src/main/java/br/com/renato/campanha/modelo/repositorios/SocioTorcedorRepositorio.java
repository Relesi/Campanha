package br.com.renato.campanha.modelo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.renato.campanha.modelo.entidades.Torcedor;
import br.com.renato.campanha.modelo.entidades.Campanha;

@Repository
public interface SocioTorcedorRepositorio extends CrudRepository<Torcedor, Long> {

	List<Torcedor> findAllBySocio(Campanha socio);

	Torcedor findByIdAndSocio(Long id, Campanha socio);

	List<Torcedor> findAll();

}
