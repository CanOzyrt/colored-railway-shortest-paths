# RouteCost — Colored Railway Shortest Paths (Java)

## Project Overview

**RouteCost** computes the minimum total cost across a railway network of cities and links. 
The program supports a colored-link rule set with **red**, **green**, and **uncolored** links. 
It validates input, builds a network, and computes the total cost between a given source and destination city.

---

## Features

- **Link Types**: `RedLink`, `GreenLink`, `UncoloredLink`
- **Rules**:
  - Red routes: can use red + uncolored links
  - Green routes: can use green + uncolored links
  - Uncolored routes: can only use uncolored links
- **Input validation**: handles missing/extra fields, invalid colors, negative distances
- **Deterministic output**: prints the rail network summary and the total cost
- **Factory Pattern**: `LinkFactory` makes it easy to add new link types
- **Unit Tests**: JUnit 5 tests under `test/`
- **Sample Inputs**: `.in` and `.gold` files under `input_tests/`

---

## Project Structure

```
solution-main/
├─ src/                     # Main source code
│  ├─ City.java
│  ├─ Link.java
│  ├─ ColoredLink.java
│  ├─ RedLink.java
│  ├─ GreenLink.java
│  ├─ UncoloredLink.java
│  ├─ LinkFactory.java
│  ├─ CityComparator.java
│  ├─ InvalidLineException.java
│  └─ RouteCost.java       # Main entry point
├─ test/                    # JUnit 5 tests
│  ├─ CityTest.java
│  ├─ CityComparatorTest.java
│  ├─ LinkTest.java
│  ├─ ColoredLinkTest.java
│  └─ LinkFactoryTest.java
├─ input_tests/             # Sample input/output and helper scripts
│  ├─ test.00.in / test.00.gold / ...
│  ├─ check.sh / mktests.sh
│  └─ README.txt
└─ docs/                    # Design and specification documents
   ├─ requirements.txt
   ├─ refactoring.txt
   ├─ buglist.txt
   ├─ specification.(pdf|tex)
   └─ design_(original|extended).pdf
```

---

## Build and Run

Requires **Java 17+**.

### Compile
```bash
javac -d out $(find src -name "*.java")
```

### Run
```bash
java -cp out RouteCost < input_tests/test.01.in
```

Expected output (from `test.01.gold`):
```
The rail network consists of:
  A 42 B
The total cost is: 42
```

---

## Input Format

- Each line describes a link:  
  `City1 [Color] Distance City2`  
  - Color is optional (`red` or `green`). If omitted, the link is uncolored.
- The list of links ends with `done`.
- A source and destination pair follows, ending again with `done`.

### Example
```
A 42 B
done
A B
done
```

---

## Testing

- **Unit tests (JUnit 5)**: located in `test/`
- **Golden tests**: compare program output with `.gold` files  
  ```bash
  java -cp out RouteCost < input_tests/test.01.in | diff -u - input_tests/test.01.gold
  ```
- **Automation**: use `input_tests/check.sh` on Linux/macOS to run all tests

---

## License

No license specified yet. If publishing as open source, consider adding one (e.g., MIT).
