package modélisationObjetAvecJPA;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "numero")
	private String numero;

	@Column(name = "solde")
	private Double solde;

	/** List<ClientBiblio> : clients pouvant accéder au compte */
	@ManyToMany(mappedBy = "comptes")
	private List<Client> clients;

	/** List<Operation> : operations réalisés sur le compte */
	@OneToMany(mappedBy = "compte")
	private List<Operation> operations;

	/**
	 * Constructeur vide
	 * 
	 */
	public Compte() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param numero
	 * @param solde
	 */
	public Compte(Integer id, String numero, Double solde) {
		this.id = id;
		this.numero = numero;
		this.solde = solde;
		Set<Client> clients;
		Set<Operation> operations;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;

	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + ", clients=" + clients + ", operations="
				+ operations + "]";
	}

	public void addOperation(Operation virement) {
		// TODO Auto-generated method stub
		
	}
}
