# Warsztat: Tworzenie obiektowej warstwy dostępu do danych (DAO)

## Cel warsztatu

Celem tego projektu jest stworzenie obiektowej warstwy dostępu do danych (DAO) przy użyciu języka Java. Repozytorium zawiera gotową implementację klasy `UserDao`, która pozwala na wykonywanie podstawowych operacji na bazie danych.

---

## Struktura projektu

### Baza danych
- **Nazwa bazy danych**: `workshop2`
- **Tabela**: `users`

### Struktura tabeli `users`
```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
```

---

## Funkcjonalności

Klasa `UserDao` umożliwia wykonywanie następujących operacji:

1. **Dodawanie użytkownika** do bazy danych (`create`).
2. **Odczyt użytkownika** na podstawie jego identyfikatora (`read`).
3. **Aktualizacja danych użytkownika** (`update`).
4. **Usuwanie użytkownika** z bazy danych (`delete`).
5. **Pobieranie wszystkich użytkowników** z tabeli (`findAll`).

---

## Jak korzystać

### 1. Przygotowanie środowiska
- Upewnij się, że masz zainstalowaną bazę danych MySQL.
- Stwórz bazę danych `workshop2` i tabelę `users` za pomocą poniższego zapytania SQL:
```sql
CREATE DATABASE workshop2;
USE workshop2;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
```

### 2. Skonfiguruj projekt Maven
W pliku `pom.xml` dodaj zależność do sterownika MySQL:
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

### 3. Konfiguracja połączenia z bazą danych
W pliku konfiguracyjnym projektu lub w kodzie ustaw dane dostępowe do bazy danych:
```java
private static final String URL = "jdbc:mysql://localhost:3306/workshop2";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

### 4. Użycie klasy `UserDao`
Przykład użycia klasy `UserDao`:
```java
public static void main(String[] args) {
    UserDao userDao = new UserDao();

    // Dodawanie nowego użytkownika
    User newUser = new User("john_doe", "john@example.com", "password123");
    userDao.create(newUser);

    // Odczyt użytkownika
    User user = userDao.read(1);
    System.out.println(user);

    // Aktualizacja użytkownika
    user.setUsername("john_updated");
    userDao.update(user);

    // Usuwanie użytkownika
    userDao.delete(1);

    // Pobieranie wszystkich użytkowników
    List<User> users = userDao.findAll();
    users.forEach(System.out::println);
}
```

---

## Przydatne zasoby

- [Dokumentacja MySQL](https://dev.mysql.com/doc/)
- [Oficjalna dokumentacja JDBC](https://docs.oracle.com/javase/tutorial/jdbc/)
- [Podstawy Maven](https://maven.apache.org/guides/index.html)

---


