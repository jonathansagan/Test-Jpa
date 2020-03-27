import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modélisationObjetAvecJPA.Operation;
import modélisationObjetAvecJPA.Virement;
import modélisationObjetAvecJPA.Compte;
import modélisationObjetAvecJPA.Adresse;
import modélisationObjetAvecJPA.Client;
import modélisationObjetAvecJPA.Banque;


public class TestTp4 {

	private static Logger LOGGER = Logger.getLogger(TestTp4.class.getName());

	/**
	 * @param args void
	 */
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_banque");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Banque banque1 = new Banque("CaisseEpargne");
		Banque banque2 = new Banque("CMB");
		
		Client client1 = new Client("bidule", "Daniela", LocalDate.now(),
				new Adresse(3, "rue des ruisseaux", 35000, "LORIENT"), banque1);
		Client client2 = new Client("Paul", "pouil", LocalDate.now(),
				new Adresse(15, "impasse des blaireaux", 29000, "QUIMPER"), banque2);
		
		Compte compte1 = new Compte(3,"18545", 2358.25);
		Compte compte2 = new Compte(1,"200B", 1250.2);
		
		Operation ope1 = new Operation( LocalDateTime.now(),800.2, "loyer", compte1);
		Operation ope2 = new Operation(LocalDateTime.now(), 100.0, "Debit", compte2);
		Operation virement = new Virement(LocalDateTime.now(), 33.0, "Debit", compte1, "vétérinaire");

		client1.addCompte(compte1);
		client1.addCompte(compte2);
		client2.addCompte(compte2);

		compte1.addOperation(virement);
		compte2.addOperation(ope1);
		compte2.addOperation(ope2);
		
		// transaction 1
				EntityTransaction t1 = entityManager.getTransaction();

				t1.begin();

				Arrays.asList(banque1, client1, client2, compte1, compte2, ope1, ope2, virement)
						.forEach(entityManager::persist);



				t1.commit();

				TypedQuery<Client> query1 = entityManager.createQuery("Select c FROM Client c", Client.class);

				for (Client c : query1.getResultList()) {
					LOGGER.log(Level.INFO, c.toString());
				}
				TypedQuery<Compte> query2 = entityManager.createQuery("Select c FROM Compte c", Compte.class);

				for (Compte c : query2.getResultList()) {
					LOGGER.log(Level.INFO, c.toString());
				}
				entityManager.close();

				entityManagerFactory.close();

	}

}
