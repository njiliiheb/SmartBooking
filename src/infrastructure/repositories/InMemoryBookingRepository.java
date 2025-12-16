package infrastructure.repositories;

import domain.entities.Booking;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Implémentation en mémoire du BookingRepository.
 */
public class InMemoryBookingRepository implements BookingRepository {
    private Map<String, Booking> bookings = new HashMap<>();

    @Override
    public void save(Booking booking) {
        bookings.put(booking.getId(), booking);
    }

    @Override
    public Booking findById(String id) {
        return bookings.get(id);
    }

    @Override
    public List<Booking> findAll() {
        return new ArrayList<>(bookings.values());
    }

    @Override
    public List<Booking> findByClientId(String clientId) {
        return bookings.values().stream()
            .filter(b -> b.getClientId().equals(clientId))
            .collect(Collectors.toList());
    }

    @Override
    public List<Booking> findByServiceId(String serviceId) {
        return bookings.values().stream()
            .filter(b -> b.getServiceId().equals(serviceId))
            .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        bookings.remove(id);
    }
}
