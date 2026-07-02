Fonctionnalités
L'application comprend les écrans et fonctionnalités suivantes :
Page d'accueil : Affichage d'une grille des séries les plus populaires (récupérées via l'API).
Recherche : Une barre de recherche permet de trouver une série spécifique par son nom.
Détails de la série : En cliquant sur une série, on accède à une fiche détaillée comprenant l'image, le résumé, la note (rating), le genre et le nombre d'épisodes.
Navigation : Gestion de la navigation entre l'accueil et les détails.

Stack Technique
Le projet respecte les contraintes techniques suivantes et utilise les dernières librairies recommandées par Google :
Langage : Kotlin
UI : 100% Jetpack Compose (pas de XML) 
Architecture : MVVM (Model-View-ViewModel) 
Injection de dépendances : Dagger Hilt 
Réseau : Retrofit 2 & GSON 
Chargement d'images : Coil 
Navigation : Navigation Compose 
Asynchronisme : Coroutines & Flow

Configuration et Lancement
Pour tester l'application :
Cloner ce dépôt sur votre machine.
Ouvrir le projet dans Android Studio (dernière version recommandée).
Laisser Gradle synchroniser les dépendances.
Lancer l'application sur un émulateur ou un appareil physique (Permission Internet requise).

API utilisée
Les données proviennent de l'API gratuite Episodate : https://www.episodate.com/api

Auteur
Projet réalisé dans le cadre d'un exercice de développement Android par LIAUTAUD Baptiste et DEMICHELIS Maxim
