package modélisationObjetAvecJPA;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@DiscriminatorValue("VIR")
public class Virement extends Operation {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Integer id;


@Column(name="beneficiaire")
private String beneficiaire;

/**
 * Constructor
 *
 * @param date
 * @param montant
 * @param modif
 * @param compte
 */
public Virement(LocalDateTime date, Double montant, String modif, Compte compte, String beneficiaire) {
	super();
	this.beneficiaire = beneficiaire;
}
}
