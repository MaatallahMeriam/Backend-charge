# Site de Gestion de Charge d'Enseignement

## Description
Ce projet est un **système de gestion de la charge d'enseignement** conçu pour permettre aux enseignants de soumettre leurs vœux d'enseignement, gérer leurs charges horaires et effectuer des réclamations. Il se compose de deux parties principales :
1. **Backend avec Spring Boot** : Fournit une API RESTful pour gérer les informations liées aux enseignants, aux cours, aux vœux d'enseignement et aux réclamations.
2. **Frontend avec React.js** : Interface utilisateur permettant aux enseignants de soumettre et consulter leurs vœux d'enseignement, consulter leur charge horaire et faire des réclamations.

Le système est connecté à une **base de données SQL** (par exemple MySQL ou PostgreSQL) pour stocker les informations nécessaires à la gestion des charges horaires des enseignants.

## Fonctionnalités
- **Backend Spring Boot** :
  - Gestion des enseignants et de leurs informations.
  - Suivi des charges horaires des enseignants.
  - Gestion des vœux d'enseignement soumis par les enseignants.
  - Gestion des réclamations et demandes de modifications par les enseignants.
  - Communication avec une base de données SQL pour stocker les informations.

- **Frontend React.js** :
  - Interface permettant aux enseignants de soumettre leurs vœux d'enseignement.
  - Visualisation de la charge horaire des enseignants.
  - Interface de réclamation pour soumettre des demandes de changement de charge horaire.

## Technologies utilisées
- **Backend** :
  - **Spring Boot** (framework Java pour le backend)
  - **Spring Data JPA** (pour la gestion de la base de données)
  - **H2 / MySQL / PostgreSQL** (base de données SQL)
  - **Spring Security** (pour la gestion de la sécurité et de l'authentification des utilisateurs)
  - **Spring Web** (pour la création de l'API RESTful)
  - **JSP / Thymeleaf** (optionnel pour la gestion de l'affichage côté serveur, si nécessaire)

- **Frontend** :
  - **React.js** (pour la création de l'interface utilisateur)
  - **Axios** (pour effectuer des requêtes HTTP vers l'API Spring Boot)
  - **Material-UI / Bootstrap** (pour les composants de l'interface)
  - **React Router** (pour la navigation entre les pages)

## Installation et exécution

### 1. Backend (Spring Boot)  
1. Clonez le repository du backend :  
   ```bash
   git clone <URL-du-repository-backend>
