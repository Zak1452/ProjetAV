package up.mi.av.projet.Q17;

import java.util.ArrayList;
import java.util.List;

import up.mi.av.projet.Q3.Etiquetage;
import up.mi.av.projet.Q3.Graphe;
/**
 * 
 * @author Zakaria Chaker
 *
 */
public class NonColoriage {
	/**
     * Méthode statique qui renvoie la liste des sommets non coloriés dans le graphe.
     *
     * @param gphe      
     * @param etiquetage 
     * @return Liste des sommets non colorés.
     */
    public static List<Integer> non_colories(Graphe gphe, Etiquetage etiquetage) {
        List<Integer> sommetsNonColories = new ArrayList<>();
        
        for (int i = 0; i < gphe.getNbSommets(); i++) 
        {
            try 
            {
                if (etiquetage.getEtiquette(i) == -1) 
                {
                    sommetsNonColories.add(i);
                }
            } catch (IllegalArgumentException e) {
                sommetsNonColories.add(i);
            }
        }
        return sommetsNonColories;
    }
   
    /**
     * Dans cette méthode main, on effectue un test afin de vérifier si la méthode non_colories génère correctement la liste des sommets du graphe non coloriés...
     * On se sert du graphe de Petersen (voir ennoncé)
     *
     * Ce test affiche la liste des sommets du graphe qui n'ont pas été coloriés... 
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
		
		System.out.println(non_colories(gphe, etiq));
    }
    */
}
