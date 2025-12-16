package domain.observers;

import domain.entities.Booking;

/**
 * Observateur pour les notifications par SMS.
 * Implémente le pattern Observer.
 */
public class SMSNotification implements NotificationObserver {
    private String apiKey;

    public SMSNotification(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public void notify(String event, Booking booking, String message) {
        System.out.println("\n📱 SMS NOTIFICATION");
        System.out.println("   API Key: " + apiKey.substring(0, 8) + "...");
        System.out.println("   Event: " + event);
        System.out.println("   Booking: #" + booking.getId());
        System.out.println("   Message: " + message);
        System.out.println("   ✅ SMS envoyé avec succès");
    }

    @Override
    public String getChannelType() {
        return "SMS";
    }
}
