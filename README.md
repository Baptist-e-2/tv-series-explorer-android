# 📱 TV Series Explorer

Application Android de découverte de séries TV, développée en Kotlin avec Jetpack Compose. Projet réalisé dans le cadre de ma formation à ESAIP.

## ✨ Fonctionnalités

- **Page d'accueil** : affichage d'une grille des séries les plus populaires (récupérées via l'API)
- **Recherche** : barre de recherche pour trouver une série par son nom
- **Détails de la série** : fiche détaillée avec image, résumé, note, genre et nombre d'épisodes
- **Navigation** : gestion fluide entre l'accueil et les détails

## 🛠️ Stack technique

- **Langage** : Kotlin
- **UI** : 100% Jetpack Compose (pas de XML)
- **Architecture** : MVVM (Model-View-ViewModel)
- **Injection de dépendances** : Dagger Hilt
- **Réseau** : Retrofit 2 & GSON
- **Chargement d'images** : Coil
- **Navigation** : Navigation Compose
- **Asynchronisme** : Coroutines & Flow

## 🚀 Configuration et lancement

1. Cloner ce dépôt
2. Ouvrir le projet dans Android Studio (dernière version recommandée)
3. Laisser Gradle synchroniser les dépendances
4. Lancer l'application sur un émulateur ou un appareil physique (permission Internet requise)

## 🌐 API utilisée

Les données proviennent de l'API gratuite [Episodate](https://www.episodate.com/api).

## 👤 Auteur

Baptiste — Étudiant ingénieur informatique à ESAIP
