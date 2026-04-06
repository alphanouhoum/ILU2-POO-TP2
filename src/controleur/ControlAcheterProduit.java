package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	
	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	
	public Etal trouverEtal(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}
	
	public Gaulois[] trouverVendeurProduit(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	public int acheterProduit(String nomVendeur, int quantite) {
		if(!verifierIdentite(nomVendeur)) {
			return -1; 
		}
		
		Etal etalVendeur = trouverEtal(nomVendeur);
		if(etalVendeur == null) {
			return -2;
		}
		return etalVendeur.acheterProduit(quantite);
	}
	
}
