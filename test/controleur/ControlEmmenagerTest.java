package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef alpha;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village de alpha", 10, 5);
		alpha = new Chef("Alpha", 10, village);
		village.setChef(alpha);
	}
	
	@Test
	void testControlEmmenager() {
		
		fail("Not yet implemented");
	}

	@Test
	void testIsHabitant() {
		fail("Not yet implemented");
	}

	@Test
	void testAjouterDruide() {
		fail("Not yet implemented");
	}

	@Test
	void testAjouterGaulois() {
		fail("Not yet implemented");
	}

}
