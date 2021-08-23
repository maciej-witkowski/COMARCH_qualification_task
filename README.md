# COMARCH: qualification task

# System rozliczeń dla wypożyczalni urządzeń

## Opis aplikacji

Aplikacja napisana w języku **Java** przy użyciu technologii **Spring Boot** spełniająca wymogi **REST API**. Składa się z obsługi różnych endpointów, warstwy z logiką biznesową oraz podłączeniem do rzeczywistej bazy danych **PostgreSQL**.

## Struktura projektu

Cały projekt opiera się na trzech głównych klasach *Customer*, *Product* oraz *Orders*. Tabele *Customer* oraz *Product* są połączone z tabelą *Orders* za pomocą relacji **One-to-many**. Aplikacja jest oparta o podstawowe rozwiązanie składające się z atrybutów **[model, repository, service, controller]** z bazową konfiguracją dla encji *Customer* oraz *Product*. Projekt wykorzystuje wzorzec **DTO**, który pozwala wysłać dane zawierające wiele atrybutów, aby zrealizować całe żądanie w jednym wywołwaniu API.

## Konfiguracja bazy danych

Do pełnego działania aplikacji potrzebna jest prosta konfiguracja bazy PostgreSQL składająca się z:

User: postgres
Password: admin
Database: rental
Port: 5432

Dodatkowo aplikacja jest zaopatrzona w konfiguracje dockerową ***(Docker compose)**, więc do pełnego działania aplikacji potrzebne jest tylko wygenerowanie pliku **.jar** oraz uruchomienie komendy ```docker-compose up```

## Opis działania endpointów

## 1. Customer

GET ```http://localhost:8080/api/v1/customer``` -> zwraca wszystkich klientów zapisanych w bazie

GET 
```http://localhost:8080/api/v1/customer/{customerId}/orders?month={month}``` -> zwraca wszystkie rekordy wypożyczeń wraz z wyceną dla klienta z id {customerId} w konkrentym miesiącu, np. month=january

POST 
```http://localhost:8080/api/v1/customer``` -> dodaje nowego klienta do bazy danych

RequestBody:
```json
{
    "firstName": "Jan",
    "lastName": "Kowalski",
    "email": "jan.kowalskin@gmail.com",
    "phoneNumber": "012-345-678"
}
```

DELETE 
```http://localhost:8080/api/v1/customer/{customerId}``` -> usuwa klienta z bazy

PUT 
```http://localhost:8080/api/v1/customer/{customerId}?{key}={value}``` -> aktualizuje poszczególne pola u konkretnego klienta w bazie

## 2. Product

GET ```http://localhost:8080/api/v1/product``` -> zwraca wszystkie produkty **(cennik)** zapisane w bazie

POST 
```http://localhost:8080/api/v1/product``` -> dodaje nowy produkt do cennika

RequestBody:
```json
{
    "name": "Telewizor",
    "brand": "Sony",
    "price": 19.99
}
```

DELETE 
```http://localhost:8080/api/v1/product/{productId}``` -> usuwa produkt z cennika

PUT 
```http://localhost:8080/api/v1/product/{productId}?{key}={value}``` -> aktualizuje poszczególne pola konkretnego produktu z cennika

## 3. Orders

GET ```http://localhost:8080/api/v1/orders``` -> zwraca wszystkie zapisane rekordy wypożyczeń wraz z wyceną

POST 
```http://localhost:8080/api/v1/orders``` -> dodaje nowy rekord wypożyczenia wraz z wyceną do bazy

RequestBody:
```json
{
    "customerId": 1,
    "name": "Pralka",
    "brand": "Bosch",
    "dateOfLoan": "2021-06-23 10:08:00",
    "dateOfReturn": "2021-06-23 12:32:00"
}
```

## Inne rozwiązania

1. Można zrezygnować z jakichkolwiek relacji między encjami z poziomu Springa, a całą logikę potrzebną do spełnienia wymogów aplikacji obsłużyć za pomocą natywnych zapytań SQL.
2. Tabelę *Orders* podzielić na dwie osobne, jedną odpowiedzialną za zarejestrowanie wypożyczenia, a drugą za obsługę wyceny. Dzięki temu schemat całego projektu może być prostszy w zrozumieniu, jednak mogłoby to negatywnie wpłynąć na performance.
3. Endpoint odpowiedzialny za przygotowywanie raportu dla klienta można zrealizować za pomocą encji *Orders* bez odnoszenia się do ścieżki ```/api/v1/customer/```, dzięki temu zapytanie mogłoby wyglądać mniej więcej tak: ```http://localhost:8080/api/v1/orders/report?id={customerId}&month={month}```. Inne rozwiązanie to użycie natywnych zapytań do bazy SQL, bezpośrednie podłączenie 3 encji i zapis tego wszystkiego funkcji.
