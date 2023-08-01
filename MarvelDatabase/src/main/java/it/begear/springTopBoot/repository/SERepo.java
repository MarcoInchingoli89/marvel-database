package it.begear.springTopBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.begear.springTopBoot.entities.Supereroe;

@Repository
public interface SERepo extends JpaRepository<Supereroe, Long>{

	//Possibilità di implementare i Query Method
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/ (cap 4)
	
	List<Supereroe> findSupereroeByAllineamento(String allineamento);
	List<Supereroe> findSupereroeByNomeOrAlterego(String nome, String alterego);
	List<Supereroe> findAll();
	
	//long countByLastname(String lastname);
	//List<Person> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
	//List<Person> findByLastnameIgnoreCase(String lastname);
	//Operatori possibili: Between, LessThan, GreaterThan
	
}
