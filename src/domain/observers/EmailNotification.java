package domain.observers;

import domain.entities.Booking;

/**
 * Observateur pour les notifications par Email.
 * Implémente le pattern Observer.
 */
public class EmailNotification implements NotificationObserver {
    private String smtpServer;

    public EmailNotification(String smtpServer) {
        this.smtpServer = smtpServer;
    }

    @Override
    public void notify(String event, Booking booking, String message) {
        System.out.println("\n📧 EMAIL NOTIFICATION");
        System.out.println("   Server: " + smtpServer);
        System.out.println("   Event: " + event);
        System.out.println("   Booking: #" + booking.getId());
        System.out.println("   Message: " + message);
        System.out.println("   ✅ Email envoyé avec succès");
    }

    @Override
    public String getChannelType() {
        return "EMAIL";
    }
}
