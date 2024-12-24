package up.mi.av.projet.Q3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
	/**
	 * Constructeur qui créé une instance de Graphe. Chaque instance aura une taille de nbSommets. Ainsi que des sommets compris entre 0 et n.
	 * Les arêtes sont créées pour chaque sommet et sont vides.
	 * 
	 * @param nbSommets
	 * @throws IllegalArgumentException
	 */
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
		System.out.println("Graphe créé, contient "+nbSommets+" sommets numérotés de 0 a " + (nbSommets-1));
	}
	
	/**
	 * Méthode qui ajoute un sommet au graphe. Vérifie si sommet appartient déjà au graphe.
	 * 
	 * @param sommet
	 * @throws IllegalArgumentException
	 */
	public void setSommet(int sommet) throws IllegalArgumentException
	{
		if(aretes.containsKey(sommet))
			throw new IllegalArgumentException("Erreur: le sommet existe deja dans le graphe.");
		this.aretes.put(sommet, new ArrayList<Integer>());
		this.nbSommets++;
			
	}
	/**
	 * @return le nombre de sommets du graphe
	 */
	public int getNbSommets()
	{	return this.nbSommets;
	}
	
	/**
	 * Méthode qui retourne une liste de voisins concerant un sommet précis du graphe.
	 * Erreur, si sommet non reconnu.
	 * 
	 * @param sommet
	 * @return la liste des voisins du sommet entré en parametre
	 */
	public List<Integer> getVoisins(int sommet) throws IllegalArgumentException{
		if(!aretes.containsKey(sommet))
			throw new IllegalArgumentException("Erreur: le sommet entre en parametre n'existe pas.");
		return this.aretes.get(sommet);
	}
	
	/**
	 * Méthode qui permet d'ajouter une relation entre deux voisins. 
	 * Si voisin non reconnu, erreur.
	 * 
	 * @param voisinA
	 * @param voisinB
	 * @throws IllegalArgumentException
	 */
	public void ajoutRelation(int voisinA, int voisinB) throws IllegalArgumentException
	{
		if(!aretes.containsKey(voisinA) || !aretes.containsKey(voisinB))
			throw new IllegalArgumentException("Erreur: le/les sommet(s) n'appartient/n'apaprtiennent pas au graphe. Pensez a les creer!");
		aretes.get(voisinA).add(voisinB);
		aretes.get(voisinB).add(voisinA);
		
	}
	
	/**
	 * @return ensemble des sommets du graphe.
	 */
	public Set<Integer> getSommets()
	{
		return this.aretes.keySet();
	}
	
}
