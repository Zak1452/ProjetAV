package up.mi.av.projet.Q12;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import up.mi.av.projet.Q3.Etiquetage;
import up.mi.av.projet.Q3.Graphe;

/**
 * 
 * @author Zakaria Chaker
 *
 */
public class UtilDegre {
	
	/**
	 * Cette méthode permet de calculer un tableau trié par ordre décroissant des sommets 
	 * en fonction du degré (nombre de voisins) de chacun.
	 * 
	 * @param gphe
	 * @return un tableau d'entiers triés dans l'odre decroissant
	 */
	public static int [] tri_degre(Graphe gphe)
	{
		List<Map.Entry<Integer, Integer>> sommetsParDegre = new ArrayList<>();
		for (Map.Entry<Integer, List<Integer>> entry : gphe.getAretes().entrySet()) 
		{
            int sommet = entry.getKey();
            int degre = entry.getValue().size(); 
            sommetsParDegre.add(new AbstractMap.SimpleEntry<>(sommet, degre));
        }
		//On utilise directement la methode .sort qui permet de faire le tri sans creer une autre methode...
        sommetsParDegre.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        int [] sommetsTries = new int[sommetsParDegre.size()];
       
        for (int i = 0; i < sommetsParDegre.size(); i++) 
        {
            sommetsTries[i] = sommetsParDegre.get(i).getKey();
        }

        return sommetsTries;
    }
	
	/**
	 *  Cette méthode implémente l'algorithme de Welsh-Powell pour colorier un graphe.
	 *  L'objectif est de minimiser le nombre de couleurs utilisées tout en respectant
	 *  la contrainte d'adjacence...
	 *  
	 * @param gphe
	 * @return Etiquetage contenant les couleurs associées à chaque sommet.
	 */
	public static Etiquetage welsh_Powell(Graphe gphe)
	{
        int [] sommetsTries = tri_degre(gphe);

        Etiquetage etiquetage = new Etiquetage();

        boolean [] couleursNonUtilisees = new boolean[gphe.getNbSommets()];

        for (int sommet: sommetsTries) {
        	
            Arrays.fill(couleursNonUtilisees, true);

            for (int voisin : gphe.getVoisins(sommet)) 
            {
                if (etiquetage.getEtiquettes().containsKey(voisin)) 
                {
                    int couleurVoisin = etiquetage.getEtiquette(voisin);
                    if (couleurVoisin < couleursNonUtilisees.length) {
                        couleursNonUtilisees[couleurVoisin] = false;
                    }
                }
            }

            int couleur = 0;
            while (!couleursNonUtilisees[couleur]) 
            {
                couleur++;
            }

            etiquetage.etiqueter(sommet, couleur);
        }

        return etiquetage;
	}
	
	/**
	 * Cette méthode main est utilisée pour tester les fonctionnalités implémentées.
	 * Elle crée un graphe simple, applique l'algorithme de tri par degré et 
	 * l'algorithme de Welsh-Powell, puis affiche les résultats.
	 * 
	 * 
	 * Pour effectuer le test, il faudra décommenter le script du bas.
	 * Le test affiche un etiquettage.
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
		
		System.out.println("Sommets triés par degre: " + Arrays.toString(tri_degre(gphe)));
		System.out.println("Résultat de l'algo Welsh-Powell: " + welsh_Powell(gphe));
	}
	*/

	
}
