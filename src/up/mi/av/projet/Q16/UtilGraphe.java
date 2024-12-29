package up.mi.av.projet.Q16;

import java.util.ArrayList;
import java.util.List;

import up.mi.av.projet.Q15.SousGraphe;
import up.mi.av.projet.Q3.Etiquetage;
import up.mi.av.projet.Q3.Graphe;

public class UtilGraphe {

	/**
	 * Cette méthode renvoie la liste des voisins non colorés d'un sommet donné dans un graphe.
	 * 
	 * Un sommet est considéré comme "non coloré" si son étiquette est égale à -1 dans l'étiquetage fourni.
	 * La méthode parcourt les voisins du sommet dans le graphe et ajoute à la liste ceux dont l'étiquette est -1.
	 * 
	 * @param gphe   Le graphe contenant les sommets et les arêtes.
	 * @param etiq   L'étiquetage des sommets du graphe.
	 * @param sommet Le sommet pour lequel on cherche les voisins non colorés.
	 * @return Une liste contenant les voisins non colorés du sommet donné.
	 */
	public static List<Integer> voisinsNonColories(Graphe gphe, Etiquetage etiq, int sommet) {

		List<Integer> voisins = new ArrayList<>();
	    
	    int[] sousGrapheVect = new int[gphe.getNbSommets()];
	    for (int i = 0; i < gphe.getNbSommets(); i++) {
	        sousGrapheVect[i] = i; 
	    }

	    int[][] matrice = SousGraphe.sousGraphe(gphe, sousGrapheVect);
	    
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
	 * Le "degré" des voisins non colorés est simplement le nombre d'éléments dans la liste des voisins 
	 * dont l'étiquette est égale à -1. Cette méthode utilise la méthode voisinsNonColories pour obtenir 
	 * la liste des voisins non colorés et retourne la taille de cette liste.
	 * 
	 * @param gphe   Le graphe contenant les sommets et les arêtes.
	 * @param etiq   L'étiquetage des sommets du graphe.
	 * @param sommet Le sommet pour lequel on calcule le degré des voisins non colorés.
	 * @return Le nombre de voisins non colorés du sommet donné.
	 */
	public static int degreNonColories(Graphe gphe, Etiquetage etiq, int sommet) {
	   
	    List<Integer> voisinsNonColories = voisinsNonColories(gphe, etiq, sommet);
	    return voisinsNonColories.size(); 
	}
}
