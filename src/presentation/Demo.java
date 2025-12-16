package presentation;

import domain.entities.*;
import domain.factories.UserFactory;
import domain.strategies.*;
import domain.observers.*;
import application.services.*;
import infrastructure.repositories.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe de démonstration de l'application SmartBooking.
 * 
 * Démontre l'utilisation de :
 * - Factory Method (création d'utilisateurs)
 * - Strategy (méthodes de paiement)
 * - Observer (notifications)
 * - Principes SOLID
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   SMARTBOOKING PLATFORM - DEMO");
        System.out.println("==========================================\n");

        // Initialisation des repositories et services
        InMemoryUserRepository userRepo = new InMemoryUserRepository();
        InMemoryBookingRepository bookingRepo = new InMemoryBookingRepository();
        BookingService bookingService = new BookingService(bookingRepo);
        PaymentService paymentService = new PaymentService();

        // ========== PATTERN 1 : Factory Method ==========
        System.out.println("\n=== PATTERN 1 : FACTORY METHOD ===");
        System.out.println("Creation d'utilisateurs via UserFactory...\n");

        Client client = UserFactory.createClient(
            "Jean Dupont", "jean@mail.com", "pass123", 
            "123 Rue Paris", "0601020304"
        );
        ServiceProvider provider = UserFactory.createProvider(
            "Marie Coiffure", "marie@salon.fr", "pass456", "Coiffure"
        );
        Admin admin = UserFactory.createAdmin(
            "Admin User", "admin@smartbooking.fr", "admin123", "IT"
        );

        userRepo.save(client);
        userRepo.save(provider);
        userRepo.save(admin);

        System.out.println("OK - Utilisateurs crees :");
        System.out.println("   " + client);
        System.out.println("   " + provider);
        System.out.println("   " + admin);

        // ========== PATTERN 2 : Observer ==========
        System.out.println("\n\n=== PATTERN 2 : OBSERVER ===");
        System.out.println("Enregistrement des observateurs de notifications...\n");

        bookingService.addObserver(new EmailNotification("smtp.gmail.com"));
        bookingService.addObserver(new SMSNotification("API_KEY_12345678"));
        bookingService.addObserver(new InAppNotification());

        // Création d'une réservation (déclenche les notifications)
        System.out.println("\nCreation d'une reservation...");
        Service service = new Service("S1", "Coupe de cheveux", "Coiffure", 
                                      "Coupe et brushing", 35.0, 60, provider.getId());
        
        Booking booking = bookingService.createBooking(
            client.getId(), 
            service.getId(), 
            LocalDateTime.now().plusDays(3), 
            service.getPrice()
        );

        // Confirmation de la réservation (déclenche les notifications)
        System.out.println("\n\nConfirmation de la reservation...");
        bookingService.confirmBooking(booking.getId());

        // ========== PATTERN 3 : Strategy ==========
        System.out.println("\n\n=== PATTERN 3 : STRATEGY ===");
        System.out.println("Paiement avec differentes strategies...\n");

        // Stratégie 1 : Carte bancaire
        System.out.println("--- Test 1 : Paiement par carte bancaire ---");
        PaymentStrategy cardStrategy = new CreditCardPayment(
            "1234567812345678", "JEAN DUPONT", "123"
        );
        Payment payment1 = paymentService.processPayment(
            booking.getId(), service.getPrice(), cardStrategy
        );
        System.out.println("Resultat: " + payment1);

        // Stratégie 2 : PayPal
        System.out.println("\n--- Test 2 : Paiement par PayPal ---");
        PaymentStrategy paypalStrategy = new PayPalPayment(
            "jean@mail.com", "paypal123"
        );
        Payment payment2 = paymentService.processPayment(
            booking.getId(), service.getPrice(), paypalStrategy
        );
        System.out.println("Resultat: " + payment2);

        // Stratégie 3 : Wallet
        System.out.println("\n--- Test 3 : Paiement par Wallet ---");
        PaymentStrategy walletStrategy = new WalletPayment("WALLET001", 100.0);
        Payment payment3 = paymentService.processPayment(
            booking.getId(), service.getPrice(), walletStrategy
        );
        System.out.println("Resultat: " + payment3);
        System.out.println("Resultat: " + payment3);

        // ========== Historique ==========
        System.out.println("\n\n=== HISTORIQUE CLIENT ===");
        List<Booking> history = bookingService.getClientHistory(client.getId());
        System.out.println("Reservations de " + client.getName() + " :");
        for (Booking b : history) {
            System.out.println("   " + b);
        }

        // ========== Annulation ==========
        System.out.println("\n\n=== ANNULATION ===");
        bookingService.cancelBooking(booking.getId());

        System.out.println("\n\n==========================================");
        System.out.println("         DEMO TERMINEE");
        System.out.println("==========================================");
    }
}
