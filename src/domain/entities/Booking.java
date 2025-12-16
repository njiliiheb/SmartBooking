package domain.entities;

import java.time.LocalDateTime;

/**
 * Réservation d'un service par un client.
 * Principe SOLID : SRP - gère uniquement les données d'une réservation
 */
public class Booking {
    public enum Status {
        PENDING, CONFIRMED, CANCELLED, COMPLETED
    }

    private String id;
    private String clientId;
    private String serviceId;
    private LocalDateTime bookingDate;
    private LocalDateTime serviceDate;
    private Status status;
    private double totalPrice;
    private String paymentId;

    public Booking(String id, String clientId, String serviceId, 
                   LocalDateTime serviceDate, double totalPrice) {
        this.id = id;
        this.clientId = clientId;
        this.serviceId = serviceId;
        this.bookingDate = LocalDateTime.now();
        this.serviceDate = serviceDate;
        this.status = Status.PENDING;
        this.totalPrice = totalPrice;
    }

    // Getters et Setters
    public String getId() { return id; }
    public String getClientId() { return clientId; }
    public String getServiceId() { return serviceId; }
    public LocalDateTime getBookingDate() { return bookingDate; }
    public LocalDateTime getServiceDate() { return serviceDate; }
    public void setServiceDate(LocalDateTime serviceDate) { this.serviceDate = serviceDate; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public double getTotalPrice() { return totalPrice; }
    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }

    public void confirm() { this.status = Status.CONFIRMED; }
    public void cancel() { this.status = Status.CANCELLED; }
    public void complete() { this.status = Status.COMPLETED; }

    @Override
    public String toString() {
        return String.format("Booking #%s - %s - %.2f€ [%s]", 
            id, serviceDate, totalPrice, status);
    }
}
