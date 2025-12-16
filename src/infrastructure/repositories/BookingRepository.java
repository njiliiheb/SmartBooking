package infrastructure.repositories;

import domain.entities.Booking;
import java.util.*;

/**
 * Repository pour la gestion des réservations.
 */
public interface BookingRepository {
    void save(Booking booking);
    Booking findById(String id);
    List<Booking> findAll();
    List<Booking> findByClientId(String clientId);
    List<Booking> findByServiceId(String serviceId);
    void delete(String id);
}
