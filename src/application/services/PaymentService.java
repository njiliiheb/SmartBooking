package application.services;

import domain.entities.Payment;
import domain.strategies.PaymentStrategy;
import java.util.*;

/**
 * Service de traitement des paiements.
 * Principe SOLID :
 * - SRP : Traitement des paiements uniquement
 * - DIP : Dépend de PaymentStrategy (abstraction)
 * 
 * Utilise le pattern Strategy pour les méthodes de paiement.
 */
public class PaymentService {
    private Map<String, Payment> payments = new HashMap<>();
    private int paymentCounter = 1;

    /**
     * Traite un paiement avec la stratégie donnée.
     * Pattern Strategy : Le type de paiement est déterminé à l'exécution.
     */
    public Payment processPayment(String bookingId, double amount, PaymentStrategy strategy) {
        System.out.println("\n💰 Traitement du paiement...");
        
        // Créer l'entité Payment
        String paymentId = "PAY" + paymentCounter++;
        Payment payment = new Payment(paymentId, bookingId, amount, strategy.getPaymentMethod());

        // Utiliser la stratégie pour effectuer le paiement
        boolean success = strategy.pay(amount);

        if (success) {
            payment.complete("TXN" + System.currentTimeMillis());
            payments.put(paymentId, payment);
            System.out.println("✅ Paiement enregistré : " + payment);
        } else {
            payment.fail();
            System.out.println("❌ Échec du paiement");
        }

        return payment;
    }

    /**
     * Récupère un paiement par son ID.
     */
    public Payment getPayment(String paymentId) {
        return payments.get(paymentId);
    }

    /**
     * Récupère tous les paiements.
     */
    public List<Payment> getAllPayments() {
        return new ArrayList<>(payments.values());
    }
}
