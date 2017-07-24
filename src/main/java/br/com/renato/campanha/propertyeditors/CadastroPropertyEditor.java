package br.com.renato.campanha.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.renato.campanha.modelo.entidades.Cadastro;
import br.com.renato.campanha.modelo.repositorios.CadastroRepositorio;

@Component
public class CadastroPropertyEditor extends PropertyEditorSupport {

	@Autowired private CadastroRepositorio cadastroRepositorio;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idCadastro = Long.parseLong(text);
		Cadastro cadastro = cadastroRepositorio.findOne(idCadastro);
		setValue(cadastro);
	}
	
}
