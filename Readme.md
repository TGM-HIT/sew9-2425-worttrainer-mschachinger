# WortTrainer

WortTrainer ist ein Java-Projekt, das einen Worttrainer implementiert. Es ermöglicht das Hinzufügen von Wort-Bild-Paaren, das zufällige Auswählen eines Wortes und das Überprüfen der Eingabe des Benutzers. Der aktuelle Zustand des Worttrainers kann in einer JSON-Datei gespeichert und geladen werden.

## Projektstruktur

- `app/src/main/java/org/example/`
    - `WortTrainer.java`: Implementiert die Hauptlogik des Worttrainers.
    - `WortTrainerSave.java`: Ermöglicht das Speichern und Laden des Worttrainers in/aus einer JSON-Datei.
    - `view/WorttrainerView.java`: Implementiert die Benutzeroberfläche für den Worttrainer.
    - `main.java`: Startet den Worttrainer.

- `app/src/test/java/org/example/`
    - `WortTrainerTest.java`: Enthält Unit-Tests für den Worttrainer.

## Abhängigkeiten

- Java
- Gradle
- JSON (org.json)

## Ausführung

1. Starte die Anwendung:
    ```sh
    ./gradlew run
    ```

## Verwendung

- Beim Start der Anwendung wird gefragt, ob ein gespeicherter Zustand geladen werden soll.
- Es kann ein neues Wort-Bild-Paar hinzugefügt werden.
- Ein Bild wird angezeigt und der Benutzer wird aufgefordert, das entsprechende Wort einzugeben.
- Die Eingabe wird überprüft und eine Statistik wird angezeigt.
- Der Benutzer kann das Spiel speichern und später fortsetzen.

## Tests

Führe die Tests mit Gradle aus:
```sh
./gradlew test