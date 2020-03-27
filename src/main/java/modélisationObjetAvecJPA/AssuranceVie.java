package modélisationObjetAvecJPA;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AssuranceVie extends Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(name="dateFin")
	private LocalDateTime dateFin;
	
	@Column(name="taux")
	private Double taux;

	public AssuranceVie() {
	}
	
	/** Constructeur
	 * @param id
	 * @param dateFin
	 * @param taux
	 */
	public AssuranceVie(Integer id, LocalDateTime dateFin, Double taux) {
		super();
		this.id = id;
		this.dateFin = dateFin;
		this.taux = taux;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	@Override
	public String toString() {
		return "AssuranceVie [id=" + id + ", dateFin=" + dateFin + ", taux=" + taux + "]";
	}

}
