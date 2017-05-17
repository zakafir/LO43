# LO43
# Problème d’habillage des tournées de chauffeurs de bus

Le problème de habillage (crew scheduling) est l’un des problèmes intervenants dans la planification des transports de bus urbains. L’habillage est l’assignation de chauffeurs aux tâches de conduites des véhicules pour réaliser les courses selon les lignes et horaires prédéfinis. L’objectif de ce projet est d’évaluer et représenter dans une interface graphique une solution du problème qui consiste en une assignation des chauffeurs aux différentes tâches de conduite identifiées. Il s’agit d’évaluer une solution réalisable et de l’afficher dans une interface graphique. Généralement, un chauffeur travaille 8 heures, avec 2 heures supplémentaires au maximum sur un service. Chaque tâche de conduite est définie par un lieu de départ, un lieu d’arrivée, une heure de départ, une heure d’arrivée. Un chauffeur exécute une succession de tâches de conduite. Le lieu d’arrivée de la tâche précédente est obligatoirement le même que le lieu de départ de la tâche suivante, dans un service de chauffeur. Des poses entre tâches de conduite peuvent être prévues (repas, pause café), mais sinon le délai entre deux tâches droit être le plus court possible.

Pour ce projet, on disposera des données du problème et d’une solution associée. La donnée du problème est un fichier décrivant toutes les tâches de conduites. Chaque tâche est composée par quatre éléments: l’heure de départ, l’heure d’arrivée, le lieu de départ et le lieu d’arrivée. Une solution du problème d’habillage associée aux données est un fichier qui décrit la succession des tâches affectées à chaque chauffeur de bus. Des fichiers Donnée et Solution seront fournis dans un format précis.

A partir des données fournies et de la solution, et éventuellement d’un fichier de configuration définissant certains paramètres (durée légale, durée d’une pause, ...), il s’agit de réaliser une interface graphique qui permet d’afficher et de visualiser la solution en relation aux données, et d’évaluer des critères de qualité de la solution tels que : le nombre de tâches et le nombre de conducteurs, le coût total de la solution, de consulter le type de service (service de matin, service de jour, service de soir et service de nuit), la durée du temps sans conduite, la durée des heures supplémentaires ... Ces critères devront être précisés en détail. On pourra s’inspirer des diagrammes de Gantt pour la représentation graphique.

# Annexe

On se base sur une journée de service. On considère le temps total de service du chauffeur comme étant l’heure de fin de la dernière tâche moins l’heure de début de la première tâche (temps effectué). Le coût d’un service pour un chauffeur est calculé en deux parties qui sont additionnées. Une partie est la valeur absolue de la différence de temps effectué par rapport aux 8h et la seconde partie est la perte sèche, qui est définie par les temps des coupures entre deux tâches qui ne sont pas maîtrisées (hors pause légale).

Par exemple:

Cas 1

 Le temps effectué par un chauffeur est 9 heures avec 1 heure de perte sèche, son coût sera de (9h – 8h) + 1 h = 2 h

Cas 2

 Le temps effectué par un chauffeur est de 6 heures avec 1 heure de la perte sèche, son coût sera donc de (8h – 6h) + 1 h = 3 h
 Le type de service est classifié en fonction de l’heure de la tâche où un chauffeur commence à travailler : le service de matin commence entre 05h00 et 07h00; le service de jour commence entre 07h00 et 17h00; le service de soir commence entre 17h00 et 20h00 et service de nuit commence entre 20h00 et 00h00.
