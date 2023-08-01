package it.begear.springTopBoot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import it.begear.springTopBoot.entities.Supereroe;
import it.begear.springTopBoot.service.SEService;

@RestController
public class RESTController {

	@Autowired
	SEService seService;

	@GetMapping("/supereroi-json")
	public List<Supereroe> getAllSupereroiAsJson() {
        return seService.listAll();
    }
	
	@PutMapping("/supereroi-json/{id}")
    public Supereroe updateSupereroeAsJson(@PathVariable Long id, @RequestBody Supereroe supereroe) {
        Supereroe existingSupereroe = seService.get(id);
        if (existingSupereroe != null) {
            existingSupereroe.setNome(supereroe.getNome());
            existingSupereroe.setAlterego(supereroe.getAlterego());
            existingSupereroe.setAllineamento(supereroe.getAllineamento());

            return seService.save(existingSupereroe);
        }
        return null; // Se il supereroe non viene trovato, verrà restituito null
    }
	
	@PostMapping("/supereroi-json")
    public Supereroe addSupereroe(@RequestBody Supereroe supereroe) {
        return seService.save(supereroe);
    }
	
	@DeleteMapping("/supereroi-json/{id}")
    public void deleteSupereroe(@PathVariable Long id) {
        Supereroe supereroe = seService.get(id);
        if (supereroe != null) {
            seService.delete(id);
        }
    }
}
