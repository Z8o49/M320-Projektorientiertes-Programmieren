# M2 · Eine Druckeranfrage beantworten
Öffne Druckeranfrage.png für die Vorführung. Druckeranfrage.puml ist die bearbeitbare PlantUML-Datei.

## Use Case und Testlauf
Das Supportprogramm läuft und wartet auf eine Problembeschreibung. Der Benutzer gibt «Mein Drucker streikt» ein und erhält «Haben sie dem Drucker alles gegeben was er braucht?». Damit endet der dargestellte Use Case. Im Programm beginnt der nächste Schleifendurchlauf. Mit exit lässt sich die Testsitzung anschliessend beenden.

Zum Nachspielen in PowerShell im Ordner TechSupportApp (mit JDK):
	
    javac -encoding UTF-8 Starter.java SupportSystem.java InputReader.java Responder.java
    java Starter

## Den Code im Diagramm wiederfinden
1. Starter.main() erzeugt das SupportSystem und ruft start() auf. Der Konstruktor hat InputReader und Responder bereits erstellt. Deshalb beginnt das Diagramm direkt beim Lesen einer Anfrage.
2. In SupportSystem.start() ruft das System reader.getInput() auf. Dieser InputReader zeigt die Eingabeaufforderung an und ruft auf seinem eigenen Scanner die Methode nextLine() auf. Beide Objekte haben in ihrem jeweiligen Besitzer den Feldnamen reader.
3. Der String gelangt über beide Rückgaben zurück zu start(). Die Prüfung startsWith("exit") ergibt false.
4. Das SupportSystem übergibt den String an responder.generateResponse(input). Im Responder werden die Schlüsselwörter der Reihe nach geprüft. Für unsere Eingabe trifft «Drucker» zu. Der Responder gibt den Antworttext zurück.
5. SupportSystem.start() gibt ihn mit System.out.println(response) aus. Die Pfeile zum Benutzer fassen die sichtbare Konsolenausgabe zusammen.

## Fragen fürs Fachgespräch
| Frage | Kurze Antwort |
|---|---|
| Wie erkenne ich einen Aufruf? | Ein durchgezogener Pfeil zeigt vom Aufrufer zum Empfänger. Auf dem Pfeil steht die Methode, etwa generateResponse(input). Lies die Zeitfolge von oben nach unten. |
| Was sind Swimlanes? | In einem Aktivitätsdiagramm teilen Swimlanes die Aktivitäten nach Zuständigkeit auf. Im Sequenzdiagramm hat jeder Teilnehmer eine Spalte mit einer senkrechten Lebenslinie. |
| Wie lange lebt ein Objekt? | Erzeugung und Zerstörung lassen sich einzeichnen. Ein X markiert die Zerstörung. Die Objekte sind hier vor der Anfrage schon vorhanden. Die schmalen Balken zeigen die Dauer eines Aufrufs innerhalb der Abfolge. Für Sekundenangaben braucht es Zeitmarkierungen. |
| Wie zeige ich einen Rückgabewert? | Mit einem gestrichelten Pfeil zurück zum Aufrufer. Im Diagramm liefert der Responder den Antworttext an das SupportSystem. |
| Wie zeige ich einen Aufruf im selben Objekt? | Der Pfeil führt zur eigenen Lebenslinie zurück. Beispiel aus dem Programmstart: start() ruft printWelcome() auf. In PlantUML wäre das S -> S : printWelcome(). |
| Wie zeige ich eine Alternative? | Ein alt-Rahmen mit else trennt alternative Abläufe und benennt ihre Bedingungen. Hier könnte man die Eingabeprüfung darstellen: Beginnt der Text mit exit, wird finished auf true gesetzt. Andernfalls wird der Responder aufgerufen. Die Grafik verfolgt die konkrete Druckeranfrage. |
| Was bedeutet dynamisch oder statisch? | Ein Sequenzdiagramm zeigt dynamisch, wer bei einer konkreten Anfrage wann welche Methode aufruft. Ein Klassendiagramm zeigt statisch, welche Klassen, Attribute, Methoden und Beziehungen es gibt. |

## Bezug zu ELIZA
Joseph Weizenbaum beschrieb ELIZA 1966. Das Programm suchte Schlüsselwörter und nutzte Regeln, um Teile der Eingabe zu einer Antwort umzuformen. Die TechSupportApp vereinfacht diese Idee: Für ein erkanntes Wort wie Drucker liefert sie einen vorgegebenen Satz.

## Quellen
- [TechSupportApp · Originalcode von JulianKaser auf GitLab](https://gitlab.com/JulianKaser/javaressources/-/tree/main/code/TechSupportApp)
- [PlantUML · Sequenzdiagramme](https://plantuml.com/sequence-diagram)
- [Joseph Weizenbaum · ELIZA, Communications of the ACM (1966)](https://doi.org/10.1145/365153.365168)
