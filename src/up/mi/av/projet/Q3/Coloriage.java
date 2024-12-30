package up.mi.av.projet.Q3;

/**
 * Cette classe permet d'implémenter une fonction permettant de vérifier si un graphe est coloriable par un etiquetage est envisageable.
 * Elle permet aussi d'effectuer un test, ce test correspond au graphe de Petersen (figure 2) du sujet.
 * 
 * @author Zakaria Chaker
 *
 */
public class Coloriage {
	
	/**
	 * Méthode statique qui prend en parametre un graphe et un etiquettage.
	 * Renvoie vrai ou faux. Si l'etiquetage existe bien et si le graphe est correctement colorié...
	 * 
	 * @param gphe
	 * @param etiq
	 * @return true/false
	 */
	public static boolean est_col(Graphe gphe, Etiquetage etiq)
	{
		if(etiq.getEtiquettes().size() < gphe.getNbSommets())
		{
			return false;
		}
		/*
		 * Pour verifier si la coloration est correcte. 
		 */
		for(int sommet: gphe.getSommets())
		{
			if(etiq.getEtiquettes().get(sommet) == null)
				return false;
			int etiquetteCourante = etiq.getEtiquette(sommet);
			for(int voisin: gphe.getVoisins(sommet))
			{
				if(etiquetteCourante == etiq.getEtiquette(voisin))
					return false;
			}
		}
		return true;
	}
	
	/**
	 * Test de la méthode est_col sur un graphe de type Patersen (graphe Q3.) 
	 * Pour effectuer le test, il suffit de décommenter le script du bas
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
		etiq.etiqueter(5, 2);
		etiq.etiqueter(6, 3);
		etiq.etiqueter(7, 3);
		etiq.etiqueter(8, 1);
		etiq.etiqueter(9, 1);
		
		System.out.print(est_col(gphe, etiq));
	}
	
	*/
}
