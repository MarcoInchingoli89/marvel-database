package it.begear.springTopBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.begear.springTopBoot.entities.Utente;
import it.begear.springTopBoot.repository.UtenteRepo;

@Service
public class UtenteService {

	@Autowired
    private UtenteRepo utenteRepo;
     
	public Utente saveUtente(Utente utente) {
        return utenteRepo.save(utente);
    }

    public Utente getUtenteByEmail(String email) {
        return utenteRepo.findByEmail(email);
    }
}
