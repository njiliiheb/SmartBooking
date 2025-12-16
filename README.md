# � SmartBooking Platform

> **Plateforme de réservation de services** - Projet académique 2025-2026  
> Architecture propre | Design Patterns | Principes SOLID

## 🚀 Lancement Rapide

```powershell
# Double-cliquez sur run-console.bat
# OU
javac -encoding UTF-8 -d bin src/**/*.java
java -cp bin presentation.Demo
```

**📖 Guide complet** : Voir [QUICK_START.md](QUICK_START.md)

## 🎓 Objectifs Pédagogiques

✅ **3 Design Patterns** différents implémentés  
✅ **5 Principes SOLID** appliqués  
✅ **Architecture en 4 couches** propre  
✅ **Code Java** maintenable et extensible  

## 🧩 Design Patterns Implémentés

| Pattern | Type | Usage |
|---------|------|-------|
| **Factory Method** | Creational | Création de différents types d'utilisateurs |
| **Strategy** | Behavioral | Méthodes de paiement interchangeables |
| **Observer** | Behavioral | Système de notifications automatiques |

## 💡 Principes SOLID

- **S**ingle Responsibility : Une classe = une responsabilité
- **O**pen/Closed : Extensible sans modification
- **L**iskov Substitution : Polymorphisme respecté
- **I**nterface Segregation : Interfaces spécifiques
- **D**ependency Inversion : Dépendances vers abstractions

## 📋 Description

Application Java de réservation de services appliquant les principes SOLID et Design Patterns.

## 🏗️ Architecture en 4 couches

```
smartbooking/
├── src/
│   ├── presentation/      # GUI JavaFX
│   ├── application/       # Services métier
│   ├── domain/           # Entités et interfaces
│   └── infrastructure/   # Persistance (simulation)
```

## 🧩 Design Patterns Implémentés

### 1. Factory Method (Creational)
- **Objectif**: Créer différents types d'utilisateurs (Client, Prestataire, Admin)
- **Avantage**: Centralise la logique de création

### 2. Strategy (Behavioral)
- **Objectif**: Gérer différentes méthodes de paiement (Carte, PayPal, Wallet)
- **Avantage**: Ajout facile de nouvelles méthodes sans modifier le code existant

### 3. Observer (Behavioral)
- **Objectif**: Notifier automatiquement les utilisateurs (Email, SMS, In-app)
- **Avantage**: Découplage entre événements et notifications

## ✅ Principes SOLID

| Principe | Application |
|----------|-------------|
| **S**RP | Chaque classe a une seule responsabilité |
| **O**CP | Extensions via interfaces (Strategy, Observer) |
| **L**SP | Substitution des implémentations |
| **I**SP | Interfaces petites et spécifiques |
| **D**IP | Dépendances vers abstractions |

## ⚙️ Fonctionnalités

- ✅ Gestion des utilisateurs (3 rôles)
- ✅ Catalogue de services
- ✅ Réservation (CRUD)
- ✅ Paiement multi-méthodes
- ✅ Notifications multi-canaux
- ✅ Recherche et filtres
- ✅ Historique

## 🚀 Compilation et Exécution

```bash
# Compiler
javac -d bin src/**/*.java

# Exécuter
java -cp bin presentation.Main
```

## 👨‍💻 Auteur
Projet académique 2025-2026
