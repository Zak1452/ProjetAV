package up.mi.av.projet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graphe {
	
	private int nbSommets;
	private Map<Integer, List<Integer>> aretes;
	
	public Graphe(int nbSommets)
	{
		this.nbSommets = nbSommets;
		this.aretes = new HashMap<>();
		for(int i=0; i<nbSommets; i++)
		{
			aretes.put(i, new ArrayList<Integer>());
		}
	}
}
