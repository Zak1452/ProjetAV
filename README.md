# ProjetAV
Scénario choisi: Sujet concours d'entrée à polytechnique (année 2018, filière MP) - Scénario 3

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
- etiqueter(int sommet, int etiquette):  Associe une étiquette (couleur) à un sommet dans le graphe. L'étiquette est un entier unique pour chaque sommet.
- getEtiquette(int sommet): Retourne l'étiquette associée à un sommet donné. Si le sommet n'a pas encore été étiqueté ou n'existe pas dans la Map, une exception est levée.

3.Coloriage.java: 
La classe Coloriage permet de vérifier si un graphe est correctement colorié, c'est-à-dire si l'étiquetage respectant les contraintes de coloriage est valide

Méthode principale:

- est_col(Graphe gphe, Etiquetage etiq): Cette méthode vérifie si un graphe est correctement colorié en fonction de l'étiquetage fourni. Un graphe est colorié correctement si: Chaque sommet a bien une étiquette assignée. Aucun sommet adjacent n'a la même étiquette. Le nombre d'étiquettes utilisées est égal au nombre de sommets du graphe.
- main(): Permet d'effectuer un test.


*Q6:

________________________________________
Exécution du programme

