package application.services;

import domain.entities.*;
import domain.observers.NotificationObserver;
import infrastructure.repositories.BookingRepository;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Service de gestion des réservations.
 * Principe SOLID : 
 * - SRP : Gestion des réservations uniquement
 * - DIP : Dépend de BookingRepository (abstraction)
 * 
 * Implémente le pattern Observer pour les notifications.
 */
public class BookingService {
    private BookingRepository bookingRepository;
    private List<NotificationObserver> observers;
    private int bookingCounter = 1;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
        this.observers = new ArrayList<>();
    }

    // Pattern Observer : Enregistrer un observateur
    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
        System.out.println("✅ Observateur ajouté : " + observer.getChannelType());
    }

    // Pattern Observer : Notifier tous les observateurs
    private void notifyObservers(String event, Booking booking, String message) {
        for (NotificationObserver observer : observers) {
            observer.notify(event, booking, message);
        }
    }

    /**
     * Crée une nouvelle réservation.
     */
    public Booking createBooking(String clientId, String serviceId, 
                                 LocalDateTime serviceDate, double totalPrice) {
        String bookingId = "B" + bookingCounter++;
        Booking booking = new Booking(bookingId, clientId, serviceId, serviceDate, totalPrice);
        bookingRepository.save(booking);

        // Notifier les observateurs
        notifyObservers("CREATED", booking, "Nouvelle réservation créée");

        return booking;
    }

    /**
     * Confirme une réservation.
     */
    public boolean confirmBooking(String bookingId) {
        Booking booking = bookingRepository.findById(bookingId);
        if (booking == null) {
            System.out.println("❌ Réservation introuvable : " + bookingId);
            return false;
        }

        booking.confirm();
        bookingRepository.save(booking);

        // Notifier les observateurs
        notifyObservers("CONFIRMED", booking, "Votre réservation est confirmée");

        return true;
    }

    /**
     * Annule une réservation.
     */
    public boolean cancelBooking(String bookingId) {
        Booking booking = bookingRepository.findById(bookingId);
        if (booking == null) {
            System.out.println("❌ Réservation introuvable : " + bookingId);
            return false;
        }

        booking.cancel();
        bookingRepository.save(booking);

        // Notifier les observateurs
        notifyObservers("CANCELLED", booking, "Votre réservation a été annulée");

        return true;
    }

    /**
     * Récupère l'historique des réservations d'un client.
     */
    public List<Booking> getClientHistory(String clientId) {
        return bookingRepository.findByClientId(clientId);
    }

    /**
     * Récupère toutes les réservations.
     */
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
