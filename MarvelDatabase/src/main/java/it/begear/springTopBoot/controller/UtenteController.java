package it.begear.springTopBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.begear.springTopBoot.entities.Utente;
import it.begear.springTopBoot.service.UtenteService;

@Controller
public class UtenteController {

	@Autowired
	UtenteService utenteService;

	// Pagina di registrazione
	@GetMapping("/registrazione")
	public String showRegistrazioneForm(Model model) {
		model.addAttribute("utente", new Utente());
		return "registrazione";
	}

	// Gestione della registrazione dell'utente
	@PostMapping("/registrazione")
	public String registrazioneUtente(Utente utente) {
		utenteService.saveUtente(utente);
		return "redirect:/";
	}

	// Pagina di login
	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	// Gestione del login dell'utente
	@PostMapping("/login")
	public String loginUtente(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        Utente utente = utenteService.getUtenteByEmail(email);

        if (utente != null && utente.getPassword().equals(password)) {
            return "redirect:/supereroi";
        } else {
            return "login";
        }
    }
	
	@GetMapping("/")
	public String redirectToLogin() {
	    return "redirect:/login";
	}
}
