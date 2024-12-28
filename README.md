# ProjetAV
Sujet concours d'entrée à polytechnique (année 2018, filière MP)

Projet réalisé par:
CHAKER Zakaria

Description du projet:


Structure du projet:
Le projet est organisé en .. packages situés dans le dossier src:
•	up.mi.av.projet.Q3
•	up.mi.av.projet.Q6
•	up.mi.av.projet.Q8
•	up.mi.av.projet.Q9
•	up.mi.av.projet.Q12

*Q3:
Ce package contient les classes principales pour gérer un graphe et l'etiquetage de ce dernier (coloriage) :
1)	Graphe.java :
Cette classe représente un graphe non orienté. Elle permet de créer et de manipuler un graphe constitué de sommets et d'arêtes. Chaque sommet est identifié par un entier unique.
Méthodes principales:
- Graphe(int nbSommets): Constructeur qui initialise un graphe avec un nombre donné de sommets. Chaque sommet est représenté par un entier allant de 0 à nbSommets - 1. Les arêtes sont vides au départ.
- setSommet(int sommet): Ajoute un nouveau sommet au graphe.
- getVoisins(int sommet): Retourne la liste des voisins pour un sommet donné.
- ajoutRelation(int voisinA, int voisinB): Ajoute une arête entre deux sommets du graphe.
- getSommets(): Retourne l'ensemble des sommets présents dans le graphe.

2. Etiquetage.java:
   

________________________________________
Exécution du programme

