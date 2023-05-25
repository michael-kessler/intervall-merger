# Coding Task - Lösung

___
Die Lösung wurde in Kotlin geschrieben und kann mit Hilfe von Gradle gebaut werden.

## Lösungsansatz

___

### Merge Funktion

Die Intervalle werden zunächst nach dem kleinsten "Start" sortiert.
Dadurch erhält man die kleinste und größte Grenze der Intervalle.

Danach wird ein mal durch die Intervalle iteriert, um alle nicht überlappten Intervalle zu finden.

### Wie kann die Robustheit sichergestellt werden, vor allem auch mit Hinblick auf sehr große Eingaben?

- Genaue Vorgaben welche Regeln die Intervalle befolgen müssen und den Rest nicht annehmen.
- Unit Tests -> Edge Cases entdecken und prüfen
- Laufzeitgeschwindigkeit auf einem Minimum halten

## Annahmen

___

- Ein Intervall ist immer in der Form [**a**,**b**] - wobei **a < b**, sowie **a** und **b** vom Typ Integer sind
- Es können gleiche a oder b Werte in der Liste übergeben werden
- Intervalle können auch negative Werte haben
- Es können nicht nur vier Intervalle in der Liste sein

## Build

___
Über Gradle kann die Kotlin-Datei kompiliert bzw. gebaut werden.

### Konsole

Benötigt: >= JDK 8

Mit folgendem Befehl erstellt man eine .jar:

```
./gradlew jar
```

Diese befindet sich dann hier ```build/libs/intervall-merger-1.0.jar```

### Über Intellij

Projekt mit Intellij öffnen und Gradle Skript ausführen.

## Ausführen

___
**Beispiel:**

````
> java -jar intervall-merger-1.0.jar [25,30] [2,19] [14,23] [4,8]
> [2,23] [25,30]
````
