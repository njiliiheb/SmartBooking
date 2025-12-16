package domain.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Prestataire - utilisateur qui fournit des services.
 * Applique LSP : peut être substitué à User sans problème.
 */
public class ServiceProvider extends User {
    private String specialty;
    private double rating;
    private List<String> serviceIds;

    public ServiceProvider(String id, String name, String email, String password, String specialty) {
        super(id, name, email, password);
        this.specialty = specialty;
        this.rating = 0.0;
        this.serviceIds = new ArrayList<>();
    }

    @Override
    public String getRole() {
        return "PROVIDER";
    }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public List<String> getServiceIds() { return serviceIds; }
    public void addService(String serviceId) { this.serviceIds.add(serviceId); }
}
