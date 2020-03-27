package modélisationObjetAvecJPA;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class Adresse {
		
	@Column(name="numero")
	private Integer numero;
	
	@Column(name="rue")
	private String rue;
	
	@Column(name="codePostal")
	private Integer codePostal;
	
	@Column(name="ville")
	private String ville;

	public Adresse() {
	}
	/** Constructeur
	 * @param numero
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Adresse(Integer numero, String rue, Integer codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
}
