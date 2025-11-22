🎯 Objectif du TP

Ce TP a pour objectifs de :

✔️ Mettre en place un service web SOAP en utilisant Spring Boot et Apache CXF
✔️ Configurer toutes les dépendances nécessaires pour permettre la génération et l’exposition d’un service SOAP
✔️ Manipuler des entités JPA (Hibernate) dans un contexte de service web
✔️ Comprendre l’exposition d’un service via WSDL et tester les opérations via SoapUI

🏗️ Architecture du Projet

Le projet est basé sur les éléments suivants :

Spring Boot 3.x
Apache CXF 4.x pour l’exposition SOAP (JAX-WS)
H2 Database en mémoire
Spring Data JPA
JAXB pour la sérialisation XML

📦 Fonctionnalités du Service SOA

Le service SOAP expose les opérations suivantes :

🧾 Operations disponibles

getComptes() → Retourne la liste de tous les comptes bancaires
getCompteById(id) → Retourne un compte spécifique via son identifiant
createCompte(solde, type) → Création d’un nouveau compte
deleteCompte(id) → Suppression d’un compte

🗂️ Structure du Projet
src/main/java/com/example/web
 ├── DemoApplication.java        # Classe principale Spring Boot
 ├── config/
 │    └── CxfConfig.java         # Configuration Apache CXF & publication SOAP
 ├── Ws/
 │    └── CompteSoapService.java # Service SOAP JAX-WS
 ├── entities/
 │    └── Compte.java            # Entité JPA + JAXB
 ├── repository/
 │    └── CompteRepository.java  # Spring Data JPA

⚙️ Configuration de l’Application
📌 application.properties
spring.application.name=Web Service SOAP

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driverClassName=org.h2.Driver

spring.jpa.hibernate.ddl-auto=update

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

server.port=8080
cxf.path=/services

🌐 URL du WSDL

Une fois l’application démarrée :

http://localhost:8080/services/ws?wsdl

🧪 Test du Service avec SoapUI

Ouvrir SoapUI

File → New SOAP Project

Entrer l’URL du WSDL :

http://localhost:8080/services/ws?wsdl


SoapUI génère automatiquement toutes les requêtes SOAP

Tester :

getComptes
getCompteById
createCompte
deleteCompte
🛠️ Exemple de Requête SOAP

<img src="" 
     alt="Diagramme SOAP" 
     style="width: 600px; border-radius: 10px;" />


