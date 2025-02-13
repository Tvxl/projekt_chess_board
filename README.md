1. Anforderungsanalyse
•	Ziele des Spiels: Ein funktionsfähiges Schachspiel, das zwei Spielern ermöglicht, gegeneinander zu spielen.
 
•	Funktionalitäten: 
o	Regelkonforme Bewegungen der Schachfiguren.
o	Anzeige des aktuellen Spielstandes (z. B. geschlagene Figuren).
o	Implementierung von Spielregeln wie Schachmatt, Patt und Rochade.
 
•	Plattform: Desktop-Anwendung (Java).
•	Benutzeroberfläche: Grafische Oberfläche mit Schachbrett und Figuren.
 
2. Lastenheft (Prototyp)
•	Spielbrett-Design: 8x8 Raster mit wechselnden Farben (hell/dunkel).
•	Figuren: 6 verschiedene Typen (Bauer, Turm, Springer, Läufer, Dame, König), jede mit einzigartigen Bewegungsregeln.
•	Spielstart: Figuren werden in der Startaufstellung geladen.
•	Interaktion: Maus- oder Tastatureingaben für Züge.
 
3. Modellierung
•	Klassendiagramme: 
o	Figuren: Jede Figur als eigene Klasse (mit Attributen wie Position und Methoden für Bewegungen).
o	Brett: Klasse für das Schachbrett (enthält Informationen zu Feldern und belegten Positionen).
o	Spielregeln: Methoden zur Validierung von Zügen.
•	Zusammenhänge: Interaktionen zwischen Figuren, Brett und Spielregeln modellieren.
•	Ablaufdiagramme: Spielablauf (z. B. Zugfolge, Validierung, Siegbedingungen).
 
4. Modelle
•	Datenstrukturen: 2D-Array zur Darstellung des Schachbretts.
•	Algorithmen: Logik zur Prüfung erlaubter Züge, Check für Schach, Schachmatt, Patt.
 
6. Testen

