package domain.entities;

import java.time.LocalDateTime;

/**
 * Classe représentant un utilisateur du système.
 * Principe SOLID appliqué : SRP (Single Responsibility Principle)
 * - Responsabilité unique : représenter les données d'un utilisateur
 */
public abstract class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime createdAt;

    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdAt = LocalDateTime.now();
    }

    // Getters et Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    /**
     * Méthode abstraite pour obtenir le rôle de l'utilisateur.
     * Permet la substitution (LSP - Liskov Substitution Principle)
     */
    public abstract String getRole();

    @Override
    public String toString() {
        return String.format("%s [%s] - %s", name, getRole(), email);
    }
}
