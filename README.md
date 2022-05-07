# Gatling perf checks example

## Prerequisites

- Java (tested with 11, Gatling recommends 8 or 11)
- Scala (tested with 2.13)
- Maven

## Run

```
$ mvn gatling:test -D"env=prod" \
-Dgatling.simulationClass=computerdatabase.X
```

where `X` is a selected scenario, e.g. `SearchComputers`
