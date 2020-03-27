package modélisationObjetAvecJPA;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "banque")

public class Banque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nom")
	private String nom;


	/** Constructeur vide
	 * 
	 */
	public Banque() {
	}

	/** Constructeur
	 * @param id
	 * @param nom
	 * 
	 */
	public Banque(String nom) {
		super();
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Banque [nom=" + nom + "]";
	}

}
