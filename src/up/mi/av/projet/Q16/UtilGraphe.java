package up.mi.av.projet.Q16;

import java.util.ArrayList;
import java.util.List;

import up.mi.av.projet.Q15.SousGraphe;
import up.mi.av.projet.Q3.Etiquetage;
import up.mi.av.projet.Q3.Graphe;

public class UtilGraphe {

	/**
	 * Cette méthode renvoie la liste des voisins non colorés d'un sommet donné dans un graphe.
	 * Un sommet est considéré comme "non coloré" si son étiquette est égale à -1....
	 * La méthode parcourt les voisins du sommet dans le graphe et ajoute à la liste ceux dont l'étiquette est -1.
	 * 
	 * @param gphe 
	 * @param etiq 
	 * @param sommet 
	 * @return la liste contenant les voisins non colorés du sommet entré en parametre.
	 */
	public static List<Integer> voisins_non_colories(Graphe gphe, Etiquetage etiq, int sommet) {

		List<Integer> voisins = new ArrayList<>();
	    
	    int [] sousGrapheVect = new int[gphe.getNbSommets()];
	    for (int i = 0; i < gphe.getNbSommets(); i++) {
	        sousGrapheVect[i] = i; 
	    }

	    int [][] matrice = SousGraphe.sous_graphe(gphe, sousGrapheVect);
	    
	    for (int i = 0; i < gphe.getNbSommets(); i++) {
	        if (matrice[sommet][i] == 1 && etiq.getEtiquette(i) == -1) {
	            voisins.add(i); 
	        }
	    }
	    return voisins; 
	}

	
	/**
	 * Cette méthode renvoie le nombre de voisins non colorés d'un sommet donné dans un graphe.
	 * 
	 * Le degre des voisins non coloré est le nombre d'éléments dans la liste des voisins 
	 * dont l'étiquette est égale à -1. Cette méthode utilise la méthode voisins_non_colories pour obtenir 
	 * la liste des voisins non colorés et retourne la taille de cette liste.
	 * 
	 * @param gphe   
	 * @param etiq  
	 * @param sommet 
	 * @return n  de voisins non colorés du sommet donné.
	 */
	public static int degre_non_colories(Graphe gphe, Etiquetage etiq, int sommet) {
	   
	    List<Integer> voisinsNonColories = voisins_non_colories(gphe, etiq, sommet);
	    return voisinsNonColories.size(); 
	}
	
	/**
	 * Dans cette méthode main, on effectue un test afin de vérifier si la méthode voisins_non_colories génère correctement la liste des voisins du graphe non coloriés...
     * On se sert du graphe de Petersen (voir ennoncé)
     *
     * Ce test affiche la liste des voisins à un sommet qui n'ont pas été coloriés... 
     * Dans ce cas, on force le sommet 5 a avoir -1 comme etiquette.
     * Pour effectuer ce test, il suffit de décommenter le scritp du bas

	 * @param args
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
		
		Etiquetage etiq = new Etiquetage();
		etiq.etiqueter(0, 1);
		etiq.etiqueter(1, 2);
		etiq.etiqueter(2, 3);
		etiq.etiqueter(3, 2);
		etiq.etiqueter(4, 3);
		etiq.etiqueter(5, -1); //Sommet non colorié...
		etiq.etiqueter(6, 3);
		etiq.etiqueter(7, 3);
		etiq.etiqueter(8, 1);
		etiq.etiqueter(9, 1);
		
		System.out.println(voisins_non_colories(gphe, etiq, 7));
		System.out.print(degre_non_colories(gphe, etiq, 2));
	}
	*/
}

	