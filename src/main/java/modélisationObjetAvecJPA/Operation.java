package modélisationObjetAvecJPA;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
@DiscriminatorValue("OP")
@Table(name = "operation")
public  class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="date")
	private LocalDateTime date;
	
	@Column(name="montant")
	private Double montant;
	
	@Column(name="motif")
	private String motif;
	
	/** Compte : compte lié à l'opération */
	@ManyToOne
	@JoinColumn(name = "id_compte")
	private Compte compte;

	
	public Operation() {
		super();
		
	}
	
	/** Constructeur
	 * @param localDateTime
	 * @param montant
	 * @param motif
	 * @param compte
	 */
	public Operation(LocalDateTime localDateTime, double montant, String motif, Compte compte) {
		super();
		this.date = localDateTime;
		this.montant = montant;
		this.motif = motif;
		this.compte = compte;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", date=" + date + ", montant=" + montant + ", motif=" + motif + "]";
	}
	
	
	

}
