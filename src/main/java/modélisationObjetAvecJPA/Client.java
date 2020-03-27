package modélisationObjetAvecJPA;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "client")
public class Client {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="dateNaissance")
	LocalDate dateNaissance;
	
	@Embedded
	private Adresse adresse;
	
	/** Banque : banque du client */
	@ManyToOne
	@JoinColumn(name = "id_banque")
	private Banque banque;

	/** List<Compte> : comptes du client */
	@ManyToMany
	@JoinTable(name = "clients_comptes", joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id"))
	private List<Compte> comptes;
	
	public Client() {
		super();
	}

	/** Constructeur
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param adresse
	 */
	public Client(String nom,String prenom, LocalDate dateNaissance,Adresse adresse, Banque banque) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.banque = banque;
		this.comptes = new ArrayList<Compte>();
	}
	
	/**
	 * méthode d'ajout de compte
	 * 
	 * @param c = compte
	 */
	public void addCompte(Compte c) {
		comptes.add(c);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ",banque=" + banque + ", prénom=" + prenom + ", dateNaissance=" + dateNaissance + ", adresse=" + adresse + "]";
	}
	
	
	
}
