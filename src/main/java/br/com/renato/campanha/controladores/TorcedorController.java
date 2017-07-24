package br.com.renato.campanha.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.renato.campanha.excecoes.CadastroInvalidoException;
import br.com.renato.campanha.modelo.entidades.Cadastro;
import br.com.renato.campanha.modelo.entidades.Torcedor;
import br.com.renato.campanha.modelo.enumeracoes.CategoriaDeTorcedor;
import br.com.renato.campanha.modelo.servicos.ServicoCadastro;
import br.com.renato.campanha.modelo.servicos.ServicoSocioTorcedor;
import br.com.renato.campanha.propertyeditors.CadastroPropertyEditor;

@Controller
@RequestMapping("/torcedor")
public class TorcedorController {
	
	@Autowired private CadastroPropertyEditor cadastroPropertyEditor;

	@Autowired private ServicoSocioTorcedor servicoSocioTorcedor;
	@Autowired private ServicoCadastro servicoCadastro;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarPizzas(Model model){
		model.addAttribute("torcedor", servicoSocioTorcedor.listar());
		model.addAttribute("categorias", CategoriaDeTorcedor.values());
		model.addAttribute("cadastros", servicoCadastro.listar());
		return "torcedor/listagem";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarTorcedor(
			Model model,
			@Valid @ModelAttribute Torcedor torcedor,
			BindingResult bindingResult){
		
		if ( bindingResult.hasErrors() ) {
			throw new CadastroInvalidoException();
			
		} else {
			servicoSocioTorcedor.salvar(torcedor);
			
		}

		model.addAttribute("torcedor", servicoSocioTorcedor.listar());
		return "torcedor/tabela-torcedor";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{torcedorId}")
	public ResponseEntity<String> deletarPizza(@PathVariable Long torcedorId){
		try {
			servicoSocioTorcedor.remover(torcedorId);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}
		
	}

	@RequestMapping(method=RequestMethod.GET, value="/{torcedorId}")
	public ResponseEntity<Torcedor> buscarPizza(@PathVariable Long torcedorId){
		Torcedor torcedor = servicoSocioTorcedor.buscar(torcedorId);
		return new ResponseEntity<>(torcedor, HttpStatus.OK); 
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Cadastro.class, cadastroPropertyEditor);
	}

}
