import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class TestJpa {
	private static final Logger LOGGER = Logger.getLogger(TestJpa.class.getName());
	public static void main(String[] args) {
		
        // étape 1 - Configuration

        // étape 2 - Construction de l'usine à EntityManager (EntityManagerFactory - vie durant toute l'application)
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");

        // étape 3 - Obtention d'une instance d'EntityManager (idéalement durée de vie courte)
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        // vérification que la connexion est ok
        LOGGER.log(Level.INFO, "EntityManager : "+entityManager.isOpen());
     
        // étape 5 - Fermeture EntityManager
        // entityManager.close();

        // A la fin de l'application, fermeture de l'EntityManagerFactory
        // entityManagerFactory.close();
	}

}
