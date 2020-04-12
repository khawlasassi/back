
# Simple REST CRUD API avec Spring Boot, Mysql, JPA and Hibernate 


## Les versions utilisées 
```bash
Spring Boot V2.2.6.RELEASE
Java 8
JUnit 5
```

## étape par étape

**1. Cloner l'application**

```bash
https://gitlab.tech.orange/craft/back.git

```

**2. Démarrer l'application**

```bash
mvn spring-boot:run
```


L'application sera démarrer sur <http://localhost:8080>.

##  Rest APIs

l'application contient CRUD APIs (ajout , modification et suppression d'une personne):

    GET /API/V1/Persons
    
    POST /API/V1/Person/add
    
    GET /API/V1/Person/{id}
    
    PUT /API/V1/Person/update/{id}
    
    DELETE /API/V1/Person/delete/{id}


