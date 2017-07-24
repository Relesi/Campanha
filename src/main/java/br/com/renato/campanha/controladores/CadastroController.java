package br.com.renato.campanha.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.renato.campanha.excecoes.CadastroInvalidoException;
import br.com.renato.campanha.modelo.entidades.Cadastro;
import br.com.renato.campanha.modelo.enumeracoes.CategoriaDeCadastro;
import br.com.renato.campanha.modelo.servicos.ServicoCadastro;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

	@Autowired private ServicoCadastro servicoCadastro;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarIngredientes(Model model){
		Iterable<Cadastro> cadastros = servicoCadastro.listar();
		
		model.addAttribute("titulo", "Listagem de Cadastro");
		model.addAttribute("cadastros", cadastros);
		model.addAttribute("categorias", CategoriaDeCadastro.values());
		return "cadastro/listagem";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarIngrediente(
			@Valid @ModelAttribute Cadastro cadastro,
			BindingResult bindingResult,
			Model model){
		
		if ( bindingResult.hasErrors() ) {
			throw new CadastroInvalidoException();
			
		} else {
			servicoCadastro.salvar(cadastro);
			
		}

		model.addAttribute("cadastros", servicoCadastro.listar());
		model.addAttribute("categorias", CategoriaDeCadastro.values());
		return "cadastro/tabela-cadastros";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarIngrediente(@PathVariable Long id){
		try {
			//CategoriaDeCadastro.remover(id);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		}catch(Exception ex){
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}
	}
	
	/*@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Cadastro buscarCadastro(@PathVariable Long id){
		Cadastro cadastro = CategoriaDeCadastro.buscar(id);
		return cadastro;
	}*/
	
}
