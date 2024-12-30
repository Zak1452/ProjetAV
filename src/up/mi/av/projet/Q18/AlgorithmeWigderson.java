package up.mi.av.projet.Q18;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import up.mi.av.projet.Q17.NonColoriage;
import up.mi.av.projet.Q3.Etiquetage;
import up.mi.av.projet.Q3.Graphe;

public class AlgorithmeWigderson {
	
	/**
     * Méthode qui implémente l'algorithme de Wigderson pour colorier un graphe en 3 couleurs.
     * 
     * @param gphe Le graphe à colorier.
     * @return L'étiquetage du graphe, ou null si le graphe n'est pas 3-coloriable.
     */
    public static Etiquetage wigderson(Graphe gphe) {
        Etiquetage etiquetage = new Etiquetage();
        
        while (true) {
            List<Integer> nonColories = NonColoriage.non_colories(gphe, etiquetage);
            
            if (nonColories.isEmpty()) {
                return etiquetage;
            }
            
            int sommet = nonColories.get(0);
            
            Set<Integer> couleursDeVoisins = new HashSet<>();
            List<Integer> voisins = gphe.getVoisins(sommet);
            
            for (int voisin : voisins) {
                try {
                    int couleurVoisin = etiquetage.getEtiquette(voisin);
                    if (couleurVoisin != -1) {
                        couleursDeVoisins.add(couleurVoisin);
                    }
                } catch (IllegalArgumentException e) {
                }
            }
            
            for (int couleur = 0; couleur < 3; couleur++) {
                if (!couleursDeVoisins.contains(couleur)) {
                    etiquetage.etiqueter(sommet, couleur);
                    break;
                }
            }
            
            if (etiquetage.getEtiquette(sommet) == -1) 
            {
                return null;
            }
        }
    }
}

