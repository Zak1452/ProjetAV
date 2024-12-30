package up.mi.av.projet.Q15;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import up.mi.av.projet.Q3.Graphe;
/**
 * Cette classe permet de générer des sous-graphes à partir d'un graphe initial.  
 * 
 * @author Zakaria Chaker
 */
public class SousGraphe {

    /**
     * Cette classe genere la matrice d'adjacence d'un sous-graphe défini par le vecteur sg.
     * 
     * @param graphe 
     * @param sg
     * @return matrice d'adjacence du sous-graphe
     * @throws IllegalArgumentException
     */
    public static int[][] sous_graphe(Graphe gphe, int[] sg) throws IllegalArgumentException {
        
    	int n = sg.length;

        Set<Integer> indices = new HashSet<>();
        for (int i: sg) {
            
            if(i < 0 || i >= gphe.getNbSommets())
				throw new IllegalArgumentException("Le vecteur sg contient des valeurs non valides...");
			if(!indices.add(i))
				throw new IllegalArgumentException("Le vecteur sg contient des doublons...");
        }

        int [][] matriceAdjacence = new int[n][n];

        //On effectue le remplissage de la matrice d'adjacence
        for (int i = 0; i < n; i++) {
            int sommet1 = sg[i];
            List<Integer> voisins1 = gphe.getVoisins(sommet1);

            for (int j = 0; j < n; j++) {
                int sommet2 = sg[j];
                matriceAdjacence[i][j] = voisins1.contains(sommet2)? 1 : 0;
            }
        }

        return matriceAdjacence;
    }
    /**
     * Dans cette méthode main, on effectue un test afin de vérifier si la méthode sousGraphe génère correctement la matrice d'adjacence d'un sous-graphe.
     * 
     * Pour cet exemple, on construit le graphe de Petersen (voir figure dans l'énoncé). 
     * Ensuite, on définit un sous-graphe à partir d'un vecteur contenant certains sommets du graphe initial.
     *
     * Ce test affiche la matrice d'adjacence du sous-graphe pour vérifier sa cohérence par rapport à la structure originale du graphe.
     * Pour effectuer ce test, il suffit de décommenter le script ci-dessous.
     * 
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
		
		
		int [] sousGrapheVect = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int [][] matriceSousGraphe = sous_graphe(gphe, sousGrapheVect);

		System.out.println("Matrice d'adjacence du sg: ");
		for (int i = 0; i < matriceSousGraphe.length; i++) 
		{
		    for (int j = 0; j < matriceSousGraphe[i].length; j++) 
		    {
		        System.out.print(matriceSousGraphe[i][j] + " ");
		    }
		    System.out.println();
		}
	}
	*/
}

