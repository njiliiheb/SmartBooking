package domain.strategies;

/**
 * Stratégie de paiement via portefeuille électronique.
 * Implémente le pattern Strategy.
 */
public class WalletPayment implements PaymentStrategy {
    private String walletId;
    private double balance;

    public WalletPayment(String walletId, double balance) {
        this.walletId = walletId;
        this.balance = balance;
    }

    @Override
    public boolean pay(double amount) {
        if (!validate()) {
            System.out.println("❌ Wallet invalide");
            return false;
        }

        if (balance < amount) {
            System.out.println("❌ Solde insuffisant : " + balance + "€ < " + amount + "€");
            return false;
        }

        // Simulation du paiement
        System.out.println("👛 Paiement via Wallet...");
        System.out.println("   Wallet ID : " + walletId);
        System.out.println("   Montant : " + amount + "€");
        balance -= amount;
        System.out.println("   Nouveau solde : " + balance + "€");
        System.out.println("✅ Paiement réussi !");
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "WALLET";
    }

    @Override
    public boolean validate() {
        return walletId != null && !walletId.isEmpty() && balance >= 0;
    }

    public double getBalance() {
        return balance;
    }
}
