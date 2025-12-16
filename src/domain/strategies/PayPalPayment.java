package domain.strategies;

/**
 * Stratégie de paiement via PayPal.
 * Implémente le pattern Strategy.
 */
public class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean pay(double amount) {
        if (!validate()) {
            System.out.println("❌ Identifiants PayPal invalides");
            return false;
        }

        // Simulation du paiement
        System.out.println("💰 Paiement via PayPal...");
        System.out.println("   Email : " + email);
        System.out.println("   Montant : " + amount + "€");
        System.out.println("✅ Paiement réussi !");
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "PAYPAL";
    }

    @Override
    public boolean validate() {
        return email != null && email.contains("@") 
            && password != null && password.length() >= 6;
    }
}
