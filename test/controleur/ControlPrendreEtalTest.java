package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		village = new Village("le village de alpha", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}
		
	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlVerifierIdentite);
		assertNotNull(controlPrendreEtal);
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.resteEtals());
		Gaulois vendeur = new Gaulois("Bonemine", 5);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "fleurs", 10);
		//Nombre de vendeur = 1 -> plus de place
		assertFalse(controlPrendreEtal.resteEtals());
		
		
		
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		Gaulois vendeur = new Gaulois("Bonemine", 5);
		village.ajouterHabitant(vendeur);
		assertNotEquals(-1, controlPrendreEtal.prendreEtal(vendeur.getNom(), "fleurs", 10));
		Gaulois asterix = new Gaulois("Asterix", 3);
		assertEquals(-1, controlPrendreEtal.prendreEtal(asterix.getNom(), "fruit", 3));
		
	}



}
