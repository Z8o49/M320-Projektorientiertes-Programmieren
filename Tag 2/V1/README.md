# Modul 320 · V1 · Angestelltenverwaltung
ZIP entpacken und im Ordner V1 mit Java 21 starten:

    java -jar Angestelltenverwaltung.jar

Die Demo legt drei Personen an, zeigt ihre Monatslöhne, korrigiert die Stunden einer Teilzeitkraft und versucht, das Stundenlimit der Praktikantin zu überschreiten.

## Code in VS Code
Öffne den Ordner V1. Die sechs Java-Dateien liegen in src. Mit installierter Java-Erweiterung kannst du in Main.java direkt auf Run klicken.

## Für die Besprechung
- Employee definiert die gemeinsamen Attribute id und name. Die ID ist nach dem Erstellen fest. setName prüft jede Namensänderung.
- Jede Subklasse ruft im Konstruktor super(id, name) auf. Danach setzt sie ihre eigenen Attribute über Methoden, die deren Werte vor der Zuweisung prüfen.
- EmployeeManager besitzt drei typisierte ArrayLists. Beim Hinzufügen prüft er, ob die ID bereits in einer der Listen vorkommt.
- Bei Intern darf auch ein neues Stundenlimit die bereits erfassten Stunden nicht unterschreiten.
- monthlyPay() zeigt eine Anwendung der Vererbung. Die passende Implementierung bestimmt den Monatslohn aus Fixlohn und berechtigtem Bonus, aus Stundenlohn mal Arbeitsstunden oder aus der festen Praktikumsvergütung.
