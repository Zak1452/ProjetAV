# ProjetAV
Scénario choisi: Sujet concours d'entrée à polytechnique (année 2018, filière MP) - Scénario 3

Projet réalisé par:
CHAKER Zakaria

Description du projet:
Ce projet implémente plusieurs algorithmes pour résoudre des problèmes de coloriage de graphes. Le projet est divisé en plusieurs packages, chacun correspondant à un algorithme ou une méthode spécifique. Le but principal est de démontrer différentes techniques de coloriage et d'analyse des graphes.

Structure du projet:
Le projet est organisé en packages situés dans le dossier src:
•	up.mi.av.projet.Q3
•	up.mi.av.projet.Q6
•	up.mi.av.projet.Q8
•	up.mi.av.projet.Q9
•	up.mi.av.projet.Q12
•	up.mi.av.projet.Q15
•	up.mi.av.projet.Q16
•	up.mi.av.projet.Q17
•	up.mi.av.projet.Q18

Chaque package contient des classes permettant de résoudre des problématiques spécifiques liées aux graphes, chaque package porte à la fin le numéro de la question correspondante.

*Q3:
Ce package contient les classes principales pour gérer un graphe et l'etiquetage de ce dernier (coloriage) :

1.Graphe.java:
Cette classe représente un graphe non orienté. Elle permet de créer et de manipuler un graphe constitué de sommets et d'arêtes. Chaque sommet est identifié par un entier unique.

Méthodes principales:

- Graphe(int nbSommets): Constructeur qui initialise un graphe avec un nombre donné de sommets. Chaque sommet est représenté par un entier allant de 0 à nbSommets - 1. Les arêtes sont vides au départ.
- setSommet(int sommet): Ajoute un nouveau sommet au graphe.
- getVoisins(int sommet): Retourne la liste des voisins pour un sommet donné.
- ajoutRelation(int voisinA, int voisinB): Ajoute une arête entre deux sommets du graphe.
- getSommets(): Retourne l'ensemble des sommets présents dans le graphe.

2.Etiquetage.java: 
Cette classe permet d'assigner une étiquette (ou couleur) à chaque sommet d'un graphe. L'étiquette est représentée par un nombre entier unique, et elle est stockée dans une Map qui associe chaque sommet à sa couleur.

Méthodes principales:

- Etiquetage: Constructeur qui initialise une instance de la classe Etiquetage en créant une nouvelle Map vide. Cette Map sera utilisée pour associer des sommets aux étiquettes.
- etiqueter(int sommet, int etiquette): Associe une étiquette (couleur) à un sommet dans le graphe. L'étiquette est un entier unique pour chaque sommet.
- getEtiquette(int sommet): Retourne l'étiquette associée à un sommet donné. Si le sommet n'a pas encore été étiqueté ou n'existe pas dans la Map, une exception est levée.

3.Coloriage.java: 
La classe Coloriage permet de vérifier si un graphe est correctement colorié, c'est-à-dire si l'étiquetage respectant les contraintes de coloriage est valide

Méthode principale:

- est_col(Graphe gphe, Etiquetage etiq): Cette méthode vérifie si un graphe est correctement colorié en fonction de l'étiquetage fourni. Un graphe est colorié correctement si: Chaque sommet a bien une étiquette assignée. Aucun sommet adjacent n'a la même étiquette. Le nombre d'étiquettes utilisées est égal au nombre de sommets du graphe.
- main(): Permet d'effectuer un test.


*Q6:

Classe implémentant un 2-coloriage d’un graphe. 

1.DeuxColoriage.java:
- deux_col(Graphe gphe)`: Retourne un 2-coloriage du graphe ou un message d'erreur.
- coloriageComposante(Graphe gphe, Etiquetage etiq, int sommet, int couleur): Effectue le coloriage de manière récursive d'une composante connexe (DFS).  
- main(): Permet de tester un 2-coloriage sur un graphe.

*Q8:

Classe dédiée à la détermination de la couleur minimale potentiellement utilisable par un sommet dans un graphe.  

1.CouleurMinimale.java:
- min_couleur_possible(Graphe gphe, Etiquetage etiq, int sommet): Retourne la plus petite couleur utilisable pour un sommet.  
- main(): Teste la méthode avec un exemple de graphe simple.  

*Q9:

Cette classe implémente une méthode gloutonne pour colorier un graphe.  

1.ColoriageGlouton.java:
- glouton(Graphe gphe, int[] vectNum): Colore un graphe en suivant l'ordre des sommets donné.  - min_couleur_possibleBis(Graphe gphe, Etiquetage etiq, int sommet): Variante de min_couleur_possible sans accepter la couleur `-1`.  
- main(): Teste le coloriage glouton sur le graphe de Petersen.

*Q12:

Classe qui implémente des méthodes pour analyser et colorier un graphe efficacement.  

1.UtilDegre.java:  
- tri_degre(Graphe gphe): Trie les sommets par ordre décroissant de degré.  
- welsh_Powell(Graphe gphe): Implémente l'algorithme de Welsh-Powell pour minimiser les couleurs.  
- main(): Effectue le tri des sommets et l'algorithme Welsh-Powell sur un graphe.
 
*Q15:

Cette classe implemente une methode permettant de générer des sous-graphes à partir d'un graphe initial.  

1.SousGraphe.java:
- sous_graphe(Graphe gphe, int[] sg): Génère la matrice d'adjacence d'un sous-graphe défini par un vecteur de sommets.  
- main(): Teste la génération de la matrice d'adjacence pour un sous-graphe.  

*Q16:

Classe fournissant des outils pour analyser les sommets non colorés d’un graphe.  

1.UtilGraphe.java: 
- voisins_non_colories(Graphe gphe, Etiquetage etiq, int sommet): Retourne les voisins non colorés d’un sommet donné.  
- degre_non_colories(Graphe gphe, Etiquetage etiq, int sommet): Calcule le nombre de voisins non colorés d’un sommet donné.  
- main(): Teste les méthodes sur un graphe avec un sommet non coloré.

*Q17:

Cette classe permettant d’implémenter une méthode identifiant les sommets non colorés d’un graphe.  

1.NonColoriage.java: 
- non_colories(Graphe gphe, Etiquetage etiq): Retourne la liste des sommets non colorés du graphe.  
- main(): Teste la méthode en affichant les sommets non colorés d’un graphe.  

*Q18:

Classe implémentant l'algorithme de Wigderson pour la coloration d’un graphe en 3 couleurs.  

1.AlgorithmeWigderson.java:
- wigderson(Graphe gphe): Colore un graphe en utilisant au maximum 3 couleurs ou retourne null si ce n’est pas possible. 
- main(): Teste l’algorithme sur un graphe, vérifie le résultat avec la méthode est_col pour valider le coloriage.  

________________________________________
Exécution du programme

Le projet doit être exécuté dans un IDE Java (Eclipse, VSCode, etc.). Pour tester les algorithmes:

- Cloner le projet depuis le dépôt.
- Ouvrir dans un IDE Java compatible.
- Décommenter les méthodes main() dans les classes où vous souhaitez effectuer un test.
  Chaque classe contient des tests correspondant à des graphes spécifiques, comme le graphe de Petersen.
- Exécuter les tests en lançant la méthode main() pour vérifier les résultats des algorithmes.
Tous les détails de chaque méthode et de ses tests sont documentés dans les commentaires du code.

________________________________________
Dépendances et prérequis

Java 8 ou plus récent.
Aucune bibliothèque externe n'est requise pour ce projet.

