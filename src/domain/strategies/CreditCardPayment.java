package domain.strategies;

/**
 * Stratégie de paiement par carte bancaire.
 * Implémente le pattern Strategy.
 */
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cardHolder, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.cvv = cvv;
    }

    @Override
    public boolean pay(double amount) {
        if (!validate()) {
            System.out.println("❌ Carte bancaire invalide");
            return false;
        }

        // Simulation du paiement
        System.out.println("💳 Paiement par carte bancaire...");
        System.out.println("   Titulaire : " + cardHolder);
        System.out.println("   Montant : " + amount + "€");
        System.out.println("✅ Paiement réussi !");
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "CREDIT_CARD";
    }

    @Override
    public boolean validate() {
        // Validation simple (pour la démo)
        return cardNumber != null && cardNumber.length() == 16 
            && cvv != null && cvv.length() == 3;
    }
}
