package infrastructure.repositories;

import domain.entities.User;
import java.util.*;

/**
 * Repository pour la gestion des utilisateurs en mémoire.
 * Principe SOLID : DIP - Interface pour l'abstraction
 */
public interface UserRepository {
    void save(User user);
    User findById(String id);
    User findByEmail(String email);
    List<User> findAll();
    List<User> findByRole(String role);
    void delete(String id);
}
