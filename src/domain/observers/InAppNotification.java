package domain.observers;

import domain.entities.Booking;

/**
 * Observateur pour les notifications in-app.
 * Implémente le pattern Observer.
 */
public class InAppNotification implements NotificationObserver {
    
    @Override
    public void notify(String event, Booking booking, String message) {
        System.out.println("\n🔔 IN-APP NOTIFICATION");
        System.out.println("   Event: " + event);
        System.out.println("   Booking: #" + booking.getId());
        System.out.println("   Message: " + message);
        System.out.println("   ✅ Notification affichée dans l'application");
    }

    @Override
    public String getChannelType() {
        return "IN_APP";
    }
}
