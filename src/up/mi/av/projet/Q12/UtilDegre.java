package up.mi.av.projet.Q12;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import up.mi.av.projet.Q3.Graphe;

/**
 * 
 * @author Zakaria Chaker
 *
 */
public class UtilDegre {
	
	/**
	 * Cette méthode permet de calculer un tableau trié par odre decroissant des sommets en fonction du degré de chacun.
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

        sommetsParDegre.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        int [] sommetsTries = new int[sommetsParDegre.size()];
       
        for (int i = 0; i < sommetsParDegre.size(); i++) 
        {
            sommetsTries[i] = sommetsParDegre.get(i).getKey();
        }

        return sommetsTries;
    }
	


	
}
