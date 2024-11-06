# LB-Projekt: Lost Ark Homework Tracker

## Projektidee

Dieses Projekt stellt eine REST-API für das Spiel **Lost Ark** bereit, mit der Spieler eine To-Do-Liste für ihre Charaktere verwalten können. Jeder User verfügt über mindestens einen Charakter, mit welchem er diverse Aktivitäten durchführen kann. Ziel der Anwendung ist es, eine übersichtliche Ansicht über wöchentliche und tägliche Aufgaben zu schaffen. Die User können sich Informationen zu ihren Charakteren und Aufgaben anzeigen lassen, diese bearbeiten oder löschen.

## Entity Relationship Diagram

*(Hier sollte das ERD-Diagramm eingefügt oder als Bild referenziert werden)*

## Technische Anforderungen

- **Docker** 27.1.1 (zur Verwaltung der Datenbank)
- **Git** (Versionsverwaltung und Projekt-Download)
- **Spring Boot** (Backend-Framework für die REST-API)
- **MySQL** (Datenbankverwaltung)

## User Stories

1. **Alle Charaktere und deren aktuellen Status anzeigen**

   Als User möchte ich meine Charaktere und deren Status anzeigen lassen, um zu wissen, welche Aufgaben anstehen.

2. **Neuen Charakter erstellen und Aufgaben zuweisen**

   Als User möchte ich einen neuen Charakter hinzufügen und diesem spezifische Aufgaben zuweisen.

3. **Nicht mehr benötigten Charakter löschen**

   Als User möchte ich einen Charakter löschen können, wenn dieser nicht mehr benötigt wird.

4. **Charaktereigenschaften und Aufgaben anpassen**

   Als User möchte ich die Eigenschaften meines Charakters sowie die zugewiesenen Aufgaben ändern.

## REST-API Dokumentation

### Endpunkte

#### Charakter-Management

- **GET /api/characters** - Alle Charaktere abrufen
- **POST /api/characters** - Neuen Charakter hinzufügen
- **GET /api/characters/{id}** - Charakter nach ID abrufen
- **PUT /api/characters/{id}** - Bestehenden Charakter aktualisieren
- **DELETE /api/characters/{id}** - Charakter löschen

#### Beispiel-JSON für POST und PUT

```bash
{
  "name": "Archer",
  "itemLevel": 1500,
  "characterClass": "Sniper",
  "raid": { "id": 1 },
  "dungeon": { "id": 1 },
  "guardian": { "id": 1 }
}
```

### Fehlerbehandlung und Validierung

Die Anwendung validiert alle eingehenden Daten, bevor sie in der Datenbank gespeichert werden. Fehlerhafte Anfragen werden mit entsprechenden HTTP-Statuscodes und beschreibenden Fehlermeldungen beantwortet, um dem Benutzer eine klare Rückmeldung zu geben.

## Abhängigkeiten

- **Git**: Zum Klonen des Repositories und Versionierung.
- **Docker**: Für das Setup und Management der MySQL-Datenbank mithilfe von Docker Compose.

## Installationsanleitung

Stellen Sie sicher, dass alle Abhängigkeiten installiert sind, bevor Sie beginnen:

1. **Repository klonen**

   Öffnen Sie ein Terminal und klonen Sie das Git-Repository:

   ```bash
   git clone https://github.com/Jokuurinio/m295_project_lb
   ```

2. **Docker-Container starten**

   Wechseln Sie in das Projektverzeichnis und starten Sie das Docker-Setup:

   ```bash
   docker-compose up -d
   ```

3. **Container prüfen**

   Vergewissern Sie sich, dass der MySQL-Container läuft, indem Sie den Befehl `docker ps` ausführen oder Docker Desktop verwenden.

4. **Spring Boot-Anwendung starten**

   Starten Sie die Spring Boot-Anwendung mit Maven:

   ```bash
   mvn spring-boot:run
   ```

5. **API-Endpunkte testen**

   Verwenden Sie Postman oder cURL, um die API-Endpunkte zu testen. Beispiele für Testanfragen finden Sie im Abschnitt "REST-API Dokumentation".

## Testplan

- **Manuelle Tests**: Die wichtigsten API-Endpunkte wurden in Insomnia manuell getestet, um sicherzustellen, dass sie die gewünschte Funktionalität bieten.
- **Positivtests**: Es wurde getestet, ob Charaktere erfolgreich erstellt, angezeigt und aktualisiert werden können.
- **Negativtests**: Es wurde sichergestellt, dass fehlende Felder und falsche Datentypen zu einer aussagekräftigen Fehlermeldung führen und dass ungültige Eingaben korrekt abgefangen werden.

## Selbstkritische Reflexion

Die Entwicklung dieses Projekts bot viele Lernerfahrungen. Herausforderungen lagen besonders in der Integration von Docker mit der Spring Boot-Datenbankkonfiguration und in der Erstellung der REST-API. Eine wichtige Erkenntnis war, wie entscheidend eine strukturierte Planung für den Erfolg des Projekts ist. Künftige Verbesserungen könnten auf eine umfassendere Fehlerbehandlung und erweiterte Tests zur Erhöhung der Stabilität fokussiert werden.

## Hilfestellungen und Quellen

- Unterstützung und Feedback von Mitlernenden und Dozenten
- Online-Ressourcen zur Konfiguration von Docker und Spring Boot
