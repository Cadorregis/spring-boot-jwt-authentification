# Java Spring Test
Test de développement Java Spring Boot Anywr.

## Fonctionnalités
* Enregistrement et connexion de l'utilisateur avec authentification JWT
* Validation des champs
* Cryptage du mot de passe avec BCrypt
* Gestion personnalisée des droits d'accès
* Mécanisme de déconnexion
* Refresh token

## Technologies
* Spring Boot 3.0
* Spring Security
* JSON Web Tokens (JWT)
* Spring Data JPA
* Hibernate
* PostgreSQL
* BCrypt
* Maven
 
## Configuration de l'environnement
* Docker
* JDK 17+
* Maven 3+

- Générez le projet à l'aide de la commande maven suivante
   * `mvn clean package`
- Exécutez le docker compose
   * `docker compose up --build`
- Accédez à pgAdmin disponible à l'adresse suivante puis créez la base de données **authuser_db**
   -> http://localhost:5050/

## API

Method | Path           | Description                                         |
-------|----------------|-----------------------------------------------------|
POST   | /auth/register | Création de compte utilisateur                      |
POST   | /auth/login    | Connexion                                           |
GET    | /users/me      | Retourne les informations de l'utilisateur connecté |
POST   | /auth/logout   | Déconnexion de l'utilisateur connecté               |

## Références
[1] https://jwt.io/introduction/
[2] https://spring.io/projects/spring-security
[3] https://projects.spring.io/spring-data-jpa/
[4] https://www.docker.com/blog/kickstart-your-spring-boot-application-development/