package br.com.renato.campanha.modelo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.renato.campanha.modelo.entidades.Campanha;

@Repository
public interface CampanhaRepositorio extends CrudRepository<Campanha, Long> {

	@Query("SELECT p FROM Campanha p WHERE p.usuario.login = ?")
	public Campanha findOneByLogin(String login);
	
	
	@Query("SELECT p1 FROM Campanha p1 INNER JOIN p1.pizzas p2 WHERE p2.nome = ?")
	public List<Campanha> listarCampanhasPorNomeTorcedor(String nomePizza);
	
}
