package up.mi.av.projet.Q18;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import up.mi.av.projet.Q17.NonColoriage;
import up.mi.av.projet.Q3.Coloriage;
import up.mi.av.projet.Q3.Etiquetage;
import up.mi.av.projet.Q3.Graphe;
/**
 * Classe implémentant l'algorithme de Wigderson pour la coloration d’un graphe en 3 couleurs.  
 * 
 * @author Zakaria Chaker
 */
public class AlgorithmeWigderson {
	
	/**
     * Méthode qui implémente l'algorithme de Wigderson pour colorier un graphe en 3 couleurs.
     * 
     * @param gphe Le graphe à colorier.
     * @return L'étiquetage du graphe, ou null si le graphe n'est pas 3-coloriable.
     */
    public static Etiquetage wigderson(Graphe gphe) {
        Etiquetage etiquetage = new Etiquetage();
        
        while (true) {
            List<Integer> nonColories = NonColoriage.non_colories(gphe, etiquetage);
            
            if (nonColories.isEmpty()) {
                return etiquetage;
            }
            
            int sommet = nonColories.get(0);
            
            Set<Integer> couleursDeVoisins = new HashSet<>();
            List<Integer> voisins = gphe.getVoisins(sommet);
            
            for (int voisin : voisins) {
                try {
                    int couleurVoisin = etiquetage.getEtiquette(voisin);
                    if (couleurVoisin != -1) {
                        couleursDeVoisins.add(couleurVoisin);
                    }
                } catch (IllegalArgumentException e) {
                }
            }
            
            for (int couleur = 0; couleur < 3; couleur++) {
                if (!couleursDeVoisins.contains(couleur)) {
                    etiquetage.etiqueter(sommet, couleur);
                    break;
                }
            }
            
            if (etiquetage.getEtiquette(sommet) == -1) 
            {
                return null;
            }
        }
    }
    /**
     * Cette méthode main teste l'algorithme de Wigderson pour la coloration d'un graphe.  
     * Elle crée un graphe de Petersen (figure 2) et applique l'algorithme pour vérifier si le graphe  
     * est 3-coloriable.  
     * 
     * Résultats affichés :  
     * - L'étiquetage produit par l'algorithme de Wigderson.  
     * - Si le coloriage est valide via la méthode `est_col`.  
     * 
     * Pour exécuter ce test, il faut décommenter le script du bas.
     * @param args Arguments de la ligne de commande.
     */
    
   /*
   
    public static void main(String[]args)
    {
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
		
		System.out.println("Etiquettage fourni par l'algo de Wigderson: "+wigderson(gphe));
		System.out.println("\nEst-ce un coloriage valide? (méthode est_col(graphe, etiquettage)): "+(Coloriage.est_col(gphe, wigderson(gphe)) ? "oui" : "non"));
    }
    
   */
}

