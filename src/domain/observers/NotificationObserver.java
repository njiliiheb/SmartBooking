package domain.observers;

import domain.entities.Booking;

/**
 * DESIGN PATTERN : Observer (Behavioral)
 * 
 * Interface pour les observateurs de notifications.
 * 
 * Problème résolu :
 * - Découple l'envoi de notifications de la logique métier
 * - Permet d'ajouter de nouveaux canaux de notification sans modifier le code existant
 * - Notification automatique sur les événements (création, confirmation, annulation)
 * 
 * Principe SOLID appliqué :
 * - OCP (Open/Closed) : Nouveaux observateurs sans modification
 * - ISP (Interface Segregation) : Interface simple
 * - DIP (Dependency Inversion) : Dépendance vers abstraction
 */
public interface NotificationObserver {
    /**
     * Méthode appelée lors d'un événement de réservation.
     * @param event Type d'événement : "CREATED", "CONFIRMED", "CANCELLED", "COMPLETED"
     * @param booking Réservation concernée
     * @param message Message de notification
     */
    void notify(String event, Booking booking, String message);

    /**
     * Retourne le type de canal de notification.
     */
    String getChannelType();
}
