package up.mi.av.projet;

import java.util.HashMap;
import java.util.Map;
/**
 * Cette classe permet d'étiqueter un graphe.
 * 
 * @author Zakaria Chaker
 *
 */
public class Etiquetage {
	
	private Map<Integer, Integer> etiquettes;
	
	/**
	 * Afin d'etiqueter un graphe, on utilisiera une Map. Chaque clé de la map aura une etiquette différente.
	 */
	public Etiquetage()
	{
		this.etiquettes = new HashMap<>();
	}
	
	/**
	 * Cette méthode permettera d'associer à chaque clé (sommet d'un graphe) de la Map, une valeur entière différente (coloration par nombre entier).
	 * 
	 * @param sommet
	 * @param etiquette
	 */
	public void etiqueter(int sommet, int etiquette) 
	{ 	
		this.etiquettes.put(sommet, etiquette);
	}

	/**
	 * @return etiquettage effectué.
	 */
	public Map<Integer, Integer> getEtiquettes()
	{	return this.etiquettes;
	}
	
	/**
	 * Méthode qui permet de retourner l'etiquette d'un sommet.
	 * Erreur, si sommet n'appartient pas ou non etiquetté.
	 * 
	 * @param sommet
	 * @return etiquette d'un sommet
	 * @throws IllegalArgumentException
	 */
	public int getEtiquette(int sommet) throws IllegalArgumentException
	{
		if(!etiquettes.containsKey(sommet) || etiquettes.get(sommet).equals(null))
			throw new IllegalArgumentException("Erreur: le sommet n'existe pas dans la relation d'etiquettage ou n'a pas été encore.");
		return this.etiquettes.get(sommet);
	}
	
}
