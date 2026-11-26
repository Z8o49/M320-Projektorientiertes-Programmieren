# Kompetenznachweis D1
Öffne im entpackten Ordner D1 ein Terminal. Starte mit einem JDK ab Version 11 eines der Programme.

    java GaragenApp.java
    java HeizungsApp.java

## Vorführung Garage
Registriere über Menüpunkt 1 das Fahrzeug ZH123. Die Übersicht zeigt «Reparatur offen». Schliesse über Menüpunkt 2 die Reparatur für 180 CHF ab. Menüpunkt 3 zeigt den aktuellen Status aller Fahrzeuge. Versuche, dieselbe Reparatur nochmals abzuschliessen. Das Fahrzeug behält seinen ersten Abschluss.

## Vorführung Heizung
Beide Räume starten bei 20 °C. Gib 1 22 ein. Nur das Wohnzimmer wechselt auf 22 °C. Gib danach 1 29 ein. Die Heizung meldet die Grenze und behält die gültigen 22 °C. Mit 0 beendest du das Programm.

## Fragen für das Fachgespräch
| Frage | Garage | Heizung |
|---|---|---|
| Wo entsteht ein Objekt? | In registrieren() erzeugt new Fahrzeug() ein eigenes Fahrzeug pro Kontrollschild. | new Heizung("Wohnzimmer") und new Heizung("Schlafzimmer") erzeugen zwei Instanzen derselben Klasse. |
| Wie funktioniert die Kapselung? | Die Attribute repariert und reparaturkosten sind private. status() liefert eine Beschreibung. reparaturAbschliessen() prüft die Kosten und ob die Reparatur noch offen ist. | solltemperatur ist private. Die Methode stelleEin() prüft die Grenzen vor dem Schreiben. beschreibung() liest den Zustand für die Anzeige. |
| Wie kommunizieren die Objekte? | Die Garage sucht das Fahrzeug und ruft fahrzeug.reparaturAbschliessen(kosten) auf. Bei der Demo erhält das Fahrzeug den Wert 180. | Die Zentrale wählt die Heizung über den Array-Index aus und ruft stelleEin(grad) mit dem Wert 22 auf. |
| Welches Attribut ändert sich? | repariert wechselt von false auf true, reparaturkosten von 0 auf 180. | Beim Wohnzimmer wechselt solltemperatur von 20 auf 22. Das Schlafzimmer hat ein eigenes Attribut. |
| Was unterscheidet die Datentypen? | Eine int-Variable enthält direkt eine ganze Zahl, ein boolean direkt true oder false. Die Variable fahrzeug vom Typ Fahrzeug enthält eine Referenz auf ein Objekt. | grad ist ein primitiver int. String und Heizung sind Referenztypen. Über eine Heizung-Referenz lassen sich Methoden des betreffenden Objekts aufrufen. |

Beide Simulationen halten ihren Zustand für die Dauer eines Programmlaufs.
