package br.com.renato.campanha.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.renato.campanha.modelo.servicos.ServicoSocioTorcedor;
import br.com.renato.campanha.modelo.servicos.ServicoCampanha;

@Controller
@RequestMapping("/campanha")
public class CampanhaController {
	
	@Autowired private ServicoCampanha servicoCampanha;
	@Autowired private ServicoSocioTorcedor servicoSocioTorcedor;

	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model){
		Model addAttribute = model.addAttribute("nomesPizzas", servicoSocioTorcedor.listarNomesSocioTorcedoresDisponiveis());
		return "cliente/busca_campanhas";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/torcedor/{nomesocioTorcedor}")
	public String index(@PathVariable String nomeTorcedor, Model model){
		Model addAttribute = model.addAttribute("capanhas", servicoCampanha.listarCampanhasQueContem(nomeTorcedor));
		return "cliente/tabela_pizzarias";
	}
	
}
