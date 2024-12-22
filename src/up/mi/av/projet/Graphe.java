package up.mi.av.projet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * On cherche à modéliser un graphe dont les sommets sont des entiers.
 * La classe Graphe est composée d'une HashMap aretes representant parfaitement l'adjacence entre les sommets du graphe.
 * 
 * @author Zakaria Chaker
 *
 */
public class Graphe {
	
	private int nbSommets;
	private Map<Integer, List<Integer>> aretes;
	
	public Graphe(int nbSommets) throws IllegalArgumentException
	{
		if(nbSommets <= 0)
			throw new IllegalArgumentException("Erreur: la taille d'un graphe ne peut pas etre inferieure ou egale a 0.");
		
		this.nbSommets = nbSommets;
		this.aretes = new HashMap<>();
		for(int i=0; i<nbSommets; i++)
		{
			this.aretes.put(i, new ArrayList<Integer>());
		}
	}
	
	/**
	 * @return le nombre de sommets du graphe
	 */
	public int getNbSommets()
	{	return this.nbSommets;
	}
	
	/**
	 * 
	 * @param sommet
	 * @return la liste des voisins du sommet entré en parametre
	 */
	public List<Integer> getVoisins(int sommet) throws IllegalArgumentException{
		if(!aretes.containsKey(sommet))
			throw new IllegalArgumentException("Erreur: le sommet entre en parametre n'existe pas.");
		return this.aretes.get(sommet);
	}
	
	public void ajoutRelation(int voisinA, int voisinB) throws IllegalArgumentException
	{
		if(!aretes.containsKey(voisinA) || !aretes.containsKey(voisinB))
			throw new IllegalArgumentException("Erreur: le/les sommet(s) n'appartient pas au graphe.");
		aretes.get(voisinA).add(voisinB);
		aretes.get(voisinB).add(voisinA);
		
	}
	
}
