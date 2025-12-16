package infrastructure.repositories;

import domain.entities.User;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Implémentation en mémoire du UserRepository.
 * Principe SOLID : SRP - Responsabilité unique = persistance des utilisateurs
 */
public class InMemoryUserRepository implements UserRepository {
    private Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }

    @Override
    public User findByEmail(String email) {
        return users.values().stream()
            .filter(u -> u.getEmail().equalsIgnoreCase(email))
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public List<User> findByRole(String role) {
        return users.values().stream()
            .filter(u -> u.getRole().equals(role))
            .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        users.remove(id);
    }
}
