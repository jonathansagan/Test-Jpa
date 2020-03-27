package modélisationObjetAvecJPA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LivretA extends Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(name="taux")
	private Double taux;
	
	public LivretA() {
	}

	/** Constructeur
	 * @param id
	 * @param taux
	 */
	public LivretA(Integer id, Double taux) {
		super();
		this.id = id;
		this.taux = taux;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

}
