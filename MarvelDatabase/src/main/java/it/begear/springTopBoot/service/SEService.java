package it.begear.springTopBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.begear.springTopBoot.entities.Supereroe;
import it.begear.springTopBoot.repository.SERepo;

@Service
public class SEService {
 
    @Autowired
    private SERepo repo;
     
    public List<Supereroe> listAll() {
        List<Supereroe> lista = repo.findAll();
        return lista;
    }
     
    public Supereroe save(Supereroe product) {
        return repo.save(product);
    }
     
    public Supereroe get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
    
    public List<Supereroe> findByAllineamento(String allineamento) {
    	return repo.findSupereroeByAllineamento(allineamento);
    }
    
    public List<Supereroe> findSupereroeByNomeOrAlterego(String nome, String alterego) {
    	return repo.findSupereroeByNomeOrAlterego(nome, alterego);
    }

    public List<Supereroe> findAll() {
        return repo.findAll();
    }
}

