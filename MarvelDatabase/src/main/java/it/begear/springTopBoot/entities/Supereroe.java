package it.begear.springTopBoot.entities;

import javax.persistence.*;

@Entity  //Questa classe corrisponde a una tabella
@Table(name="supereroi") //corrisponde al nome della tabella (entità)
public class Supereroe {
	
	@Id  // Obbligatorio
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //ID incrementale su tutta la tabella
	@Column(name = "id")  //corrisponde al nome della colonna (attributo)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "alterego")
	private String alterego;
	
	@Column(name = "superpotere")
	private String superpotere;
	
	@Column(name = "allineamento")
	private String allineamento;
	
	@Column(name = "origini")
	private String origini;

	public Supereroe() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAlterego() {
		return alterego;
	}

	public void setAlterego(String alterego) {
		this.alterego = alterego;
	}

	public String getSuperpotere() {
		return superpotere;
	}

	public void setSuperpotere(String superpotere) {
		this.superpotere = superpotere;
	}

	public String getAllineamento() {
		return allineamento;
	}

	public void setAllineamento(String allineamento) {
		this.allineamento = allineamento;
	}

	public String getOrigini() {
		return origini;
	}

	public void setOrigini(String origini) {
		this.origini = origini;
	}
	
}
