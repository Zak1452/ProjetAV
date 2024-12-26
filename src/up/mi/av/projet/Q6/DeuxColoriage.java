package up.mi.av.projet.Q6;

import up.mi.av.projet.Q3.Etiquetage;
import up.mi.av.projet.Q3.Graphe;

/**
 * Cette classe permet d'implémenter une méthode statique qui renvoie l'etiquetagge d'un graphe 2-coloriable.
 * Si le graphe n'est pas 2-coloriable il y a un message d'erreur qui est renvoyé.
 * Il est possible dans cette classe d'effectuer directement un test.
 * 
 * @author Zakaria Chaker 
 *
 */
public class DeuxColoriage {
	
	/**
	 * Cette méthode statique renvoie un 2-coloriage du graphe entré en parametre.
	 * L'etiquettage est renvoyé ssi le graphe entré en parametre est 2-coloriable.
	 * On utilisera des couleurs 0 et 1.
	 * Si le graphe n'est pas 2-coloriable, message d'erreur envoyé.
	 * 
	 * @param gphe
	 * @return Etiquetage du graphe entré en parametre.
	 */
	public static Etiquetage deux_col(Graphe gphe)
	{
		Etiquetage etiq = new Etiquetage();
		
		//Initialisation des etiquettes toutes à -1.
		for(int sommet: gphe.getSommets())
		{
			etiq.etiqueter(sommet, -1);
		}
		
		//On effectue un parcours en profondeur DFS, des composantes conxxes du graphe.
		for(int sommet: gphe.getSommets())
		{
			if(etiq.getEtiquette(sommet) == -1)
			{
				if(!coloriageComposante(gphe, etiq, sommet, 0))
				{
					System.err.println("Une 2-coloration pour ce graphe n'est pas possible.");
					return null;
				}
			}
		}
		return etiq;
	}
	
	/**
	 * Méthode statique qui permet de colorer une composante connexe du graphe G.
	 * Elle effectue un DFS et  un appel recursif afin de colorier les voisins de la bonne maniere en respectant les contraintes de la 2 coloration.
	 * La compléxité est quadratique...
	 * @param gphe
	 * @param etiq
	 * @param sommet
	 * @param couleur
	 * @return vrai ou faux, si la coloration de la composante se fera ou pas
	 */
	public static boolean coloriageComposante(Graphe gphe, Etiquetage etiq, int sommet, int couleur)
	{
		etiq.etiqueter(sommet, couleur);
		for(int voisin: gphe.getVoisins(sommet))
		{
			int couleurVoisin = etiq.getEtiquette(voisin);
			
			if(couleurVoisin == -1)
			{
				if(!coloriageComposante(gphe, etiq, voisin, 1-couleur))
				{
					return false;
				}
			}
			else if(couleurVoisin == couleur)
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * On effectue dans cette méthode main, un test simple afin de vérifier si une 2-coloration est possible pour un graphe de ce genre:
	 * 
	 * 0 1
	 * |\|
	 * 2-3
	 * 
	 * Pour effectuer le test, il faudra décommenter le script du bas.
	 * Le test renvoie faux. Pour tester le cas où ce dernier est faux, il faut décommenter la ligne qui construit une arête entre 0 et 3. (Un 2-coloration ne sera pas possible dans ce cas, mais une 3-coloration)
	 * @param args
	 */
	
	/*
	public static void main(String []args)
	{
		Graphe gphe = new Graphe(4);
		gphe.ajoutRelation(0, 1);
		gphe.ajoutRelation(0, 2);
		gphe.ajoutRelation(1, 3);
		gphe.ajoutRelation(2, 3);
		//gphe.ajoutRelation(0, 3);
		
		System.out.println(up.mi.av.projet.Q3.Coloriage.est_col(gphe, deux_col(gphe)));
	}
	*/

}
