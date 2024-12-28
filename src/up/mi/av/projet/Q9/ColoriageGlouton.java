package up.mi.av.projet.Q9;

import up.mi.av.projet.Q3.Etiquetage;
import up.mi.av.projet.Q3.Graphe;

/**
 * 
 * @author Zakaria Chaker
 *
 */
public class ColoriageGlouton {

	/**
	 * Méthode gloutonne qui permet de colorier un graphe en utilisant l'ordre des sommets contenu dans le vecteur.
	 * 
	 * @param gphe
	 * @param vectNum
	 * @return Etiquetage des sommets avec les couleurs assignées
	 * @throws IllegalArgumentException
	 */
	public static Etiquetage glouton(Graphe gphe, int [] vectNum) throws IllegalArgumentException 
	{
		if(vectNum.length != gphe.getNbSommets())
		{
			throw new IllegalArgumentException("Erreur: le tableau representant l'ordre de numérotation doit avoir la meme taille que le nombre de sommets.");
		}
		
		boolean [] sommetsUtilises = new boolean[gphe.getNbSommets()];
		
		for(int sommet: vectNum)
		{
			if(sommet < 0 || sommet >= gphe.getNbSommets())
				throw new IllegalArgumentException("Le tableau representant l'ordre de numérotation contient des sommets non valides...");

			if(sommetsUtilises[sommet])
				throw new IllegalArgumentException("Le tableau representant l'ordre de numérotation contient des doublons...");
			
			sommetsUtilises[sommet] = true;
		}
		
		Etiquetage etiq = new Etiquetage();
		
		//On initialise les etiquettes du graphe à -1
		for (int i = 0; i < gphe.getNbSommets(); i++) {
	        etiq.etiqueter(i, -1); 
	    }
		for(int sommet: vectNum)
		{
			int couleur = min_couleur_possibleBis(gphe, etiq, sommet);
			etiq.etiqueter(sommet, couleur);
		}
		
		return etiq;
	}
	
	/**
	 * Cette méthode issue du package Q8, correspond à une variante de min_couleur_possible. En effet comme preicsé dans l'ennoncé la couleur -1 fait partie de l'esemble des couleurs possibles. 
	 * Dans ce cas non, afin d'eviter certaines incohérences...
	 * 
	 * @param gphe
	 * @param etiq
	 * @param sommet
	 * @return couleur minimale
	 * @throws IllegalArgumentException
	 */
	public static int min_couleur_possibleBis(Graphe gphe, Etiquetage etiq, int sommet) throws IllegalArgumentException
	{
	    boolean [] couleursUtilisees = new boolean [gphe.getNbSommets()];

	    
	    for (int voisin : gphe.getVoisins(sommet)) {
	        int couleurVoisin = etiq.getEtiquette(voisin);

	        if (couleurVoisin >= 0 && couleurVoisin < gphe.getNbSommets()) {
	            couleursUtilisees[couleurVoisin] = true;
	        }
	    }

	    for (int couleur = 0; couleur < gphe.getNbSommets(); couleur++) {
	        if (!couleursUtilisees[couleur]) {
	            return couleur;
	        }
	    }
		
		throw new IllegalArgumentException("Aucun couleur valide n'a ete retrouvee");

	}
	/**
	 * On effectue dans cette méthode main, un test afin de vérifier si l'algorithme glouton effectue un bon coloriage: correct et cohérent.
	 * Dans cet exeple, on effectue le test dans un le graphe de Petersen de la figure 2 (voir ennoncé)
	 * 
	 * Pour effectuer le test, il faudra décommenter le script du bas.
	 * Au cours de ce test, on obtient un etiquetage. Puis on effectue une verification avec la methode est_col (issue du pacakge Q3).
	 * @param args
	 */
	/*
	public static void main(String[] args) {
		
        
        Graphe gphe = new Graphe(10);
        gphe.ajoutRelation(0, 5);
		gphe.ajoutRelation(0, 4);
		gphe.ajoutRelation(0, 6);
		gphe.ajoutRelation(4, 8);
		gphe.ajoutRelation(4, 3);
		gphe.ajoutRelation(3, 7);
		gphe.ajoutRelation(3, 9);
		gphe.ajoutRelation(9, 2);
		gphe.ajoutRelation(9, 6);
		gphe.ajoutRelation(6, 1);
		gphe.ajoutRelation(1, 8);
		gphe.ajoutRelation(1, 7);
		gphe.ajoutRelation(7, 5);
		gphe.ajoutRelation(8, 2);
		gphe.ajoutRelation(2, 5);
		
        int [] vectNum = {1, 3, 4, 0, 2, 6, 5, 9, 8, 7};

        try {
            Etiquetage etiq = ColoriageGlouton.glouton(gphe, vectNum);
            System.out.println("Coloriage des sommets: " + etiq);
            System.out.println("C'est un coloriage: "+Coloriage.est_col(gphe, etiq));
        } catch (IllegalArgumentException erreur) {
            System.err.println(erreur.getMessage());
        }
    }
    */
	
}
