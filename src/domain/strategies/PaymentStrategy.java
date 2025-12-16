package domain.strategies;

/**
 * DESIGN PATTERN : Strategy (Behavioral)
 * 
 * Interface pour les différentes stratégies de paiement.
 * 
 * Problème résolu :
 * - Permet d'ajouter de nouvelles méthodes de paiement sans modifier le code existant
 * - Évite les if/else multiples pour chaque type de paiement
 * 
 * Principe SOLID appliqué :
 * - OCP (Open/Closed) : Ouvert à l'extension, fermé à la modification
 * - ISP (Interface Segregation) : Interface simple et ciblée
 * - DIP (Dependency Inversion) : Les classes dépendent de cette abstraction
 */
public interface PaymentStrategy {
    /**
     * Effectue un paiement.
     * @param amount Montant à payer
     * @return true si le paiement réussit, false sinon
     */
    boolean pay(double amount);

    /**
     * Retourne le nom de la méthode de paiement.
     */
    String getPaymentMethod();

    /**
     * Valide si le paiement peut être effectué.
     */
    boolean validate();
}
