package it.begear.springTopBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.begear.springTopBoot.entities.Utente;

public interface UtenteRepo extends JpaRepository<Utente, Long> {

	Utente findByEmail(String email);
	
}
