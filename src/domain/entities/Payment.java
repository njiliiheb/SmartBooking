package domain.entities;

import java.time.LocalDateTime;

/**
 * Représente un paiement effectué.
 * Principe SOLID : SRP - gère uniquement les données d'un paiement
 */
public class Payment {
    public enum Status {
        PENDING, COMPLETED, FAILED, REFUNDED
    }

    private String id;
    private String bookingId;
    private double amount;
    private String method; // "CREDIT_CARD", "PAYPAL", "WALLET"
    private Status status;
    private LocalDateTime paymentDate;
    private String transactionId;

    public Payment(String id, String bookingId, double amount, String method) {
        this.id = id;
        this.bookingId = bookingId;
        this.amount = amount;
        this.method = method;
        this.status = Status.PENDING;
    }

    // Getters et Setters
    public String getId() { return id; }
    public String getBookingId() { return bookingId; }
    public double getAmount() { return amount; }
    public String getMethod() { return method; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public LocalDateTime getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public void complete(String transactionId) {
        this.status = Status.COMPLETED;
        this.paymentDate = LocalDateTime.now();
        this.transactionId = transactionId;
    }

    public void fail() {
        this.status = Status.FAILED;
        this.paymentDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("Payment #%s - %.2f€ via %s [%s]", 
            id, amount, method, status);
    }
}
