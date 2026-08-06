# 🎮 Family Business (`FamilyBusiness`)

An interactive **Java & Spring Boot** digital implementation of the strategic card game **Family Business**, where players command mobster families competing for territorial dominance.

---

## 🎯 Game Overview & Mechanics

**Family Business** is a turn-based strategy game for 2–6 players competing for mob supremacy.

- 👥 **Mobster Squad Management**: Each player controls a family of 9 mobsters.
- 🎯 **The Hit List**: Players play tactical cards to place opponent mobsters onto the Hit List.
- ⚔️ **Mob Wars & Elimination**: When the Hit List reaches critical capacity, a Mob War erupts, eliminating mobsters at the top of the queue each turn.
- 🛡️ **Counter Play**: Execute counter-tactics like *"Take It on the Lam"* to rescue family mobsters from the Hit List.

---

## 🛠️ Architecture & Built With

- **Language**: Java 11 / Java 17
- **Framework**: Spring Boot (REST & Core Dependency Injection)
- **Build System**: Apache Maven
- **Design Patterns**: Command Pattern for card execution, Factory Pattern for mobster/card entity creation, and Observer Pattern for game state loops.

---

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/128jso/FamilyBusiness.git
cd FamilyBusiness
```

### 2. Build & Run
```bash
# Using Maven Wrapper
./mvnw spring-boot:run
```

---

## 📄 License & Credits
- **Author**: John So (`128jso`)
- **Game Design Inspiration**: Mayfair Games
