package domain.factories;

import domain.entities.*;

/**
 * DESIGN PATTERN : Factory Method (Creational)
 * 
 * Problème résolu :
 * - Centraliser la création de différents types d'utilisateurs
 * - Encapsuler la logique de création complexe
 * - Faciliter l'ajout de nouveaux types d'utilisateurs
 * 
 * Principe SOLID appliqué :
 * - OCP (Open/Closed) : Ouvert à l'extension (nouveaux types d'utilisateurs)
 * - SRP : Responsabilité unique = créer des utilisateurs
 */
public class UserFactory {
    private static int clientCounter = 1;
    private static int providerCounter = 1;
    private static int adminCounter = 1;

    /**
     * Crée un utilisateur selon son type.
     * @param type Type d'utilisateur : "CLIENT", "PROVIDER", "ADMIN"
     * @param name Nom de l'utilisateur
     * @param email Email de l'utilisateur
     * @param password Mot de passe
     * @return User créé ou null si type invalide
     */
    public static User createUser(String type, String name, String email, String password) {
        switch (type.toUpperCase()) {
            case "CLIENT":
                return new Client("C" + clientCounter++, name, email, password);
            
            case "PROVIDER":
                return new ServiceProvider("P" + providerCounter++, name, email, password, "General");
            
            case "ADMIN":
                return new Admin("A" + adminCounter++, name, email, password, "IT");
            
            default:
                System.out.println("Type d'utilisateur invalide : " + type);
                return null;
        }
    }

    /**
     * Crée un prestataire avec spécialité.
     */
    public static ServiceProvider createProvider(String name, String email, 
                                                  String password, String specialty) {
        return new ServiceProvider("P" + providerCounter++, name, email, password, specialty);
    }

    /**
     * Crée un client avec adresse et téléphone.
     */
    public static Client createClient(String name, String email, String password, 
                                      String address, String phone) {
        return new Client("C" + clientCounter++, name, email, password, address, phone);
    }

    /**
     * Crée un admin avec département.
     */
    public static Admin createAdmin(String name, String email, String password, 
                                    String department) {
        return new Admin("A" + adminCounter++, name, email, password, department);
    }

    // Reset des compteurs (utile pour les tests)
    public static void resetCounters() {
        clientCounter = 1;
        providerCounter = 1;
        adminCounter = 1;
    }
}
