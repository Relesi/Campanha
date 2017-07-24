package br.com.renato.campanha.modelo.entidades;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.renato.campanha.modelo.enumeracoes.CategoriaDeTorcedor;

@Entity
public class Torcedor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	private String nome;

	@NotNull
	private String email;

	@NotNull
	@Enumerated(EnumType.STRING)
	private CategoriaDeTorcedor categoria;

	@ManyToMany
	private Set<Cadastro> cadastros;

	@ManyToOne
	@JoinColumn(name="SOCIO")
	@JsonIgnore
	private Campanha socio;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPreco() {
		return email;
	}

	public void setPreco(String email) {
		this.email = email;
	}

	public CategoriaDeTorcedor getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDeTorcedor categoria) {
		this.categoria = categoria;
	}

	public Set<Cadastro> getIngredientes() {
		return cadastros;
	}

	public void setCadastro(Set<Cadastro> cadastros) {
		this.cadastros = cadastros;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Torcedor other = (Torcedor) obj;
		if (categoria != other.categoria)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public Campanha getSocio() {
		return socio;
	}

	public void setSocio(Campanha socio) {
		this.socio = socio;
	}
	
}
