package it.begear.springTopBoot.controller;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import it.begear.springTopBoot.entities.Supereroe;
import it.begear.springTopBoot.service.SEService;


@Controller
public class SEController {

	@Autowired
	SEService seService;

	@RequestMapping("/supereroi")
	public String viewHomePage(Model model) {
		List<Supereroe> listaSupereroi = seService.listAll();
		model.addAttribute("listaSupereroi", listaSupereroi);
		return "index";
	}

	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		Supereroe se = new Supereroe();
		model.addAttribute("se", se);
		return "add-se";
	}

	@RequestMapping("/addSE")
	public String saveProduct(@ModelAttribute("se") Supereroe se) {
		seService.save(se);
		return "redirect:/supereroi";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditSE(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit-se");
		Supereroe se = seService.get(id);
		mav.addObject("se", se);
		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteHero(@PathVariable(name = "id") int id) {
		seService.delete(id);
		return "redirect:/supereroi";
	}

	@RequestMapping("/search")
	public String search(@RequestParam(value = "allineamento", required = false) String allineamento,
			@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "alterego", required = false) String alterego, Model model) {
		List<Supereroe> listaSupereroi = new ArrayList<>();
		if (allineamento != null) {
			// Logica per la ricerca per allineamento
			listaSupereroi = seService.findByAllineamento(allineamento);
		}

		if (nome != null || alterego != null) {
			// Logica per la ricerca per nome o alter ego
			listaSupereroi.addAll(seService.findSupereroeByNomeOrAlterego(nome, alterego));
		}
		
		if (listaSupereroi.isEmpty()) {
	        // Nessun supereroe trovato, reindirizza a una pagina di errore o a una pagina di nessun risultato
	        return "supereroe-non-trovato";
	    }

		model.addAttribute("listaSupereroi", listaSupereroi);
		return "index";
	}

}
