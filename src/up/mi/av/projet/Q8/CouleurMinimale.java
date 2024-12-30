package up.mi.av.projet.Q8;

import up.mi.av.projet.Q3.Etiquetage;
import up.mi.av.projet.Q3.Graphe;

/**
 * Classe qui permet d'implémenter la méthode permettant de trouver la couleur minimale que peut avoir un sommet d'un graphe.
 * @author Zakaria Chaker
 *
 */
public class CouleurMinimale {
	
	/**
	 * Méthode qui renvoie l'entier (couleur) le plus petit possible, pour un sommet qui n'est pas utilisé par ses voisins dans le graphe.
	 * Salon l'ennoncé, il est également possible de choisir -1 comme couleur si valide.
	 * @param gphe
	 * @param etiq
	 * @param sommet
	 * @return la couleur minimale non utilisée par les voisins.
	 * @throws IllegalArgumentException
	 */
	public static int min_couleur_possible(Graphe gphe, Etiquetage etiq, int sommet) throws IllegalArgumentException
	{
	    boolean [] couleursUtilisees = new boolean [gphe.getNbSommets()];
	    boolean valNegative = false;
	    
	    for (int voisin : gphe.getVoisins(sommet)) {
	        int couleurVoisin = etiq.getEtiquette(voisin);
	        if(couleurVoisin == -1)
	        	valNegative = true;
	        if (couleurVoisin >= 0 && couleurVoisin < gphe.getNbSommets()) {
	            couleursUtilisees[couleurVoisin] = true;
	        }
	    }

	    if(!valNegative)
	    	return -1;
	    
	    // Trouver la première couleur non utilisée
	    for (int couleur = 0; couleur < gphe.getNbSommets(); couleur++) {
	        if (!couleursUtilisees[couleur]) {
	            return couleur;
	        }
	    }
		
		throw new IllegalArgumentException("Aucun couleur valide n'a ete retrouvee");

	}
	/**
	 * On effectue dans cette méthode main, un test simple afin de vérifier quelle couleur minimale sera potentiellement utilisée pour colorer un sommet.
	 * Voici un exemple de graphe.
	 * 
	 * 0-1
	 * |/|
	 * 2-3
	 * 
	 * Pour effectuer le test, il faudra décommenter le script du bas.
	 * Le test renvoie la couleur minimale possible que peut avoir 2. 
	 * @param args
	 */
	
	/*
	
	public static void main(String[]args)
	{
		Graphe gphe = new Graphe(4);
		gphe.ajoutRelation(0, 1);
		gphe.ajoutRelation(0, 2);
		gphe.ajoutRelation(1, 3);
		gphe.ajoutRelation(1, 2);
		gphe.ajoutRelation(2, 3);
		
		Etiquetage etiq = new Etiquetage();
		etiq.etiqueter(0, -1);
		etiq.etiqueter(1, 0);
		etiq.etiqueter(2, 3);
		etiq.etiqueter(3, 1);

	
		System.out.println("\nEtiquetage réalisé par construction: "+ etiq);
		System.out.println("\nLa couleur minimale que peut avoir le sommet 2 est: "+min_couleur_possible(gphe, etiq, 2));
		
	}
	
	*/
	
}
