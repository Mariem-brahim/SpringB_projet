#  Demo - Gestion des Produits

Application web **Spring Boot** offrant une API REST pour la gestion des produits (CRUD) avec une interface HTML simple.

---

## 🛠 Technologies utilisées

| Technologie | Version |
|-------------|---------|
| Java | 17 |
| Spring Boot | 3.3.4 |
| Spring Data JPA | — |
| MariaDB | 10.x |
| Maven | (wrapper inclus) |
| HTML / CSS / JavaScript | — |

---

##  Prérequis

Avant de lancer le projet, assurez-vous d'avoir installé :

-  **JDK 17** ou supérieur — [Télécharger](https://adoptium.net/)
-  **MariaDB** (ou MySQL) — [Télécharger](https://mariadb.org/download/)
-  **IDE** (recommandé : IntelliJ IDEA, Eclipse, ou VS Code)

---

##  Installation et lancement

### 1. Cloner ou télécharger le projet

```bash
git clone <url-du-repo>
cd demo
```

### 2. Configurer la base de données

Démarrez MariaDB, puis créez la base de données :

```sql
CREATE DATABASE demo;
```

> ⚠ Les tables seront créées automatiquement par Hibernate (`ddl-auto=update`).

### 3. Vérifier la configuration

Le fichier `src/main/resources/application.properties` contient :

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/demo
spring.datasource.username=root
spring.datasource.password=root
```

Modifiez ces valeurs si vos identifiants MariaDB sont différents.

### 4. Lancer l'application

**Avec Maven Wrapper :**

```bash
# Sur Windows
./mvnw.cmd spring-boot:run

# Sur Linux/Mac
./mvnw spring-boot:run
```

**Ou depuis votre IDE :**
- Ouvrez `DemoApplication.java`
- Cliquez sur ▶️ à côté de `public static void main`

### 5. Accéder à l'interface

Une fois le serveur démarré (port `8080`), ouvrez votre navigateur :

-  **Liste / Ajout des produits** : http://localhost:8080/test.html
-  **Modification d'un produit** : http://localhost:8080/modfier.html

---

## Endpoints de l'API

Base URL : `http://localhost:8080/api`

| Méthode | Endpoint | Description | Body |
|---------|----------|-------------|------|
| `GET` | `/afficher` | Liste tous les produits | — |
| `GET` | `/trouver/{id}` | Récupère un produit par ID | — |
| `POST` | `/enregestrer` | Ajoute un nouveau produit | `{ "name": "...", "email": "..." }` |
| `PUT` | `/modifier/{id}` | Modifie un produit existant | `{ "name": "...", "email": "..." }` |
| `DELETE` | `/suprimer?id={id}` | Supprime un produit | — |

###  Exemple avec curl

```bash
# Ajouter un produit
curl -X POST http://localhost:8080/api/enregestrer \
  -H "Content-Type: application/json" \
  -d '{"name":"Produit A","email":"test@example.com"}'

# Afficher tous les produits
curl http://localhost:8080/api/afficher

# Supprimer un produit
curl -X DELETE "http://localhost:8080/api/suprimer?id=1"
```

---

##  Structure du projet

```
demo/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── DemoApplication.java          # Point d'entrée
│   │   │   ├── controllers/
│   │   │   │   └── UserController.java       # Endpoints REST
│   │   │   ├── models/
│   │   │   │   ├── Produit.java              # Entité JPA
│   │   │   │   ├── Users.java
│   │   │   │   ├── Taches.java
│   │   │   │   └── Notifications.java
│   │   │   ├── repositories/
│   │   │   │   └── ProduitRepository.java    # Accès BDD
│   │   │   └── services/
│   │   │       └── ProduitService.java       # Logique métier
│   │   └── resources/
│   │       ├── application.properties        # Configuration
│   │       └── static/
│   │           ├── test.html                 # Interface principale
│   │           └── modfier.html              # Interface modification
│   └── test/
│       └── java/com/example/demo/
│           └── DemoApplicationTests.java
├── pom.xml                                   # Dépendances Maven
├── mvnw / mvnw.cmd                          # Maven Wrapper
└── README.md
```

