
# Projet Java : Inversion de Contrôle et Injection de Dépendances

## Description
Ce projet est un TP (Travaux Pratiques) réalisé en Java avec IntelliJ IDEA. Il vise à illustrer les concepts d'**inversion de contrôle (IoC)** et d'**injection de dépendances** (dynamique et statique), tout en respectant le principe SOLID d'**ouverture à l'extension et fermeture à la modification**. L'application est structurée en **trois couches** : DAO (accès aux données), Métier (logique métier) et Présentation (interface utilisateur).

L'objectif fonctionnel est de **calculer une température** en utilisant soit une base de données fictive, soit un service web (simulé ici pour démontrer un couplage faible). Le projet met en avant la flexibilité et la modularité grâce à une architecture basée sur des interfaces et des implémentations interchangeables.

## Structure du Projet
Le code est organisé en **quatre packages** :

1. **`dao`** :
    - Contient l'interface `IDao` et son implémentation `DaoImpl` (simule une base de données locale).

2. **`ext`** :
    - Contient une implémentation alternative `DaoImplV2` de l'interface `IDao` (simule un accès via un service web).

3. **`metier`** :
    - Contient l'interface `IMetier` et son implémentation `MetierImpl` (effectue le calcul de la température en utilisant une instance de `IDao`).

4. **`pres`** :
    - Contient deux versions de la couche présentation :
        - `PresentationV1` : Injection de dépendances **statique** (codée en dur).
        - `PresentationV2` : Injection de dépendances **dynamique** basée sur un fichier de configuration (`config.txt`).

### Fichier de Configuration
Le fichier `config.txt` est utilisé dans `PresentationV2` pour spécifier dynamiquement les classes à instancier. Exemple de contenu :
```
ext.DaoImplV2
metier.MetierImpl
```
Cela permet de découpler les dépendances et de rendre l'application facilement extensible.

## Concepts Mis en Œuvre
- **Inversion de Contrôle (IoC)** : Les dépendances sont gérées par une entité externe (manuellement via le code ou via un fichier de configuration).
- **Injection de Dépendances** :
    - Statique dans `PresentationV1`.
    - Dynamique dans `PresentationV2` grâce à la réflexion (Java Reflection).
- **Couplage Faible** : Les implémentations spécifiques (`DaoImpl`, `DaoImplV2`) sont interchangeables grâce à l'utilisation d'interfaces.
- **Architecture en Couches** : Séparation claire entre DAO, Métier et Présentation.
- **Principe SOLID (Open/Closed)** : L'application est fermée à la modification mais ouverte à l'extension via de nouvelles implémentations.

## Prérequis
- **Java** : Version 8 ou supérieure.
- **IDE** : IntelliJ IDEA (recommandé) ou tout autre IDE compatible avec Java.
- **Dépendances** : Aucune bibliothèque externe n'est requise, le projet utilise uniquement la bibliothèque standard de Java.

## Installation et Exécution
1. Clonez le dépôt GitHub :
   ```
   git clone https://github.com/votre-utilisateur/votre-projet.git
   ```
2. Ouvrez le projet dans IntelliJ IDEA.
3. Configurez le fichier `config.txt` dans le répertoire racine (si vous utilisez `PresentationV2`).
4. Exécutez l'application :
    - Pour la version statique : Lancez la classe `PresentationV1`.
    - Pour la version dynamique : Lancez la classe `PresentationV2`.

## Exemple d'Utilisation
- **Statique (`PresentationV1`)** : Les dépendances sont codées en dur dans le code.
- **Dynamique (`PresentationV2`)** : Modifiez `config.txt` pour changer l'implémentation de `IDao` (ex. passer de `DaoImpl` à `DaoImplV2`) sans modifier le code source.

## Contribution
Les contributions sont les bienvenues ! Pour proposer des améliorations :
1. Forkez le projet.
2. Créez une branche pour vos modifications (`git checkout -b feature/amélioration`).
3. Soumettez une Pull Request.

## Auteur
- [Votre Nom] - Étudiant/Développeur Java

## Licence
Ce projet est sous licence MIT - voir le fichier [LICENSE](LICENSE) pour plus de détails.
### Mise à Jour : Intégration de Spring
Le projet inclut désormais deux nouvelles classes principales pour démontrer l'inversion de contrôle et l'injection de dépendances avec **Spring** :
- **`SpringXMLMain`** : Utilise une configuration basée sur un fichier XML (`applicationContext.xml`).
- **`SpringAnnotationMain`** : Utilise une configuration basée sur les annotations Spring.

#### Dépendances pour la Version Spring XML
Pour exécuter la version basée sur XML (`SpringXMLMain`), ajoutez le fichier de configuration Spring suivant (par exemple, `applicationContext.xml`) dans le dossier `src/main/resources` :

```xml
<bean id="d" class="dao.DaoImpl"></bean>
<bean id="metier" class="metier.MetierImpl">
    <constructor-arg ref="d"></constructor-arg>
</bean>