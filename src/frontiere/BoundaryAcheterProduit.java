package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Village;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
		Gaulois [] vendeurs = controlAcheterProduit.trouverVendeurProduit(produit);
		
		if(vendeurs.length == 0 || vendeurs == null) {
			System.out.println("Désolé, personne ne vend ce produit au marché");
			return;
			
		}
		else {
			int choixUtilisateur = -1;
			do {
				System.out.println("Chez quel commerçant voulez-vous acheter des fleurs ?");
				for (int i =0; i<vendeurs.length; i++) {
					System.out.println(i + " - "+ vendeurs[i].getNom());
				}
				choixUtilisateur = Clavier.entrerEntier("");
				if(choixUtilisateur > vendeurs.length || choixUtilisateur==0) {
					System.out.println("Vous devez choisir le chiffre 1 et "+ vendeurs.length+ " !");
				}
				
			} while (choixUtilisateur!=1 && choixUtilisateur>vendeurs.length);
			
			String nomVendeur = vendeurs[choixUtilisateur-1].getNom();
			int nbAchat = Clavier.entrerEntier("Combien de fleurs voulez-vous acheter ?");
			
			int control = controlAcheterProduit.acheterProduit(nomVendeur, nbAchat);
			if(control == -1) {
				System.out.println("Je suis désolée " +nomAcheteur+ " mais il faut être un habitant de notre village pour commercer ici.");
			}else if(control == -2) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
				
			}else {
				System.out.println(nomAcheteur+ " achete "+nbAchat+" "+ produit+ " à"+ nomVendeur);
			}
			
			
			
			
				
			
		}
			
			
			
		
	}
}
