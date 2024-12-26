package up.mi.av.projet.Q8;

import up.mi.av.projet.Q3.Etiquetage;
import up.mi.av.projet.Q3.Graphe;
/**
 * 
 * @author Zakaria Chaker
 *
 */
public class CouleurMinimale {
	
	/**
	 * Méthode qui renvoie l'entier (couleur) le plus petit possible, pour un sommet qui n'est pas utilisé par ses voisins  dans le graphe
	 * @param gphe
	 * @param etiq
	 * @param sommet
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static int min_couleur_possible(Graphe gphe, Etiquetage etiq, int sommet) throws IllegalArgumentException
	{
	    boolean [] couleursUtilisees = new boolean [gphe.getNbSommets()];
	    
	    for (int voisin : gphe.getVoisins(sommet)) {
	        int couleurVoisin = etiq.getEtiquette(voisin);
	        if (couleurVoisin >= 0 && couleurVoisin < gphe.getNbSommets()) {
	            couleursUtilisees[couleurVoisin] = true;
	        }
	    }

	    // Trouver la première couleur non utilisée
	    for (int couleur = 0; couleur < gphe.getNbSommets(); couleur++) {
	        if (!couleursUtilisees[couleur]) {
	            return couleur;
	        }
	    }
		
		throw new IllegalArgumentException("Aucun couleur valide n'a ete retrouvee");

	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[]args)
	{
		Graphe gphe = new Graphe(4);
		gphe.ajoutRelation(0, 1);
		gphe.ajoutRelation(0, 2);
		gphe.ajoutRelation(1, 3);
		gphe.ajoutRelation(1, 2);
		gphe.ajoutRelation(2, 3);
		
		Etiquetage etiq = new Etiquetage();
		etiq.etiqueter(0, 0);
		etiq.etiqueter(1, 1);
		etiq.etiqueter(2, 3);
		etiq.etiqueter(3, 4);

		
		
		System.out.println(etiq);
		System.out.println(min_couleur_possible(gphe, etiq, 2));
		
	}
}
