package domain.entities;

/**
 * Service proposé par un prestataire.
 * Principe SOLID : SRP - représente uniquement un service
 */
public class Service {
    private String id;
    private String name;
    private String category;
    private String description;
    private double price;
    private int duration; // en minutes
    private String providerId;
    private boolean available;

    public Service(String id, String name, String category, String description, 
                   double price, int duration, String providerId) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.providerId = providerId;
        this.available = true;
    }

    // Getters et Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public String getProviderId() { return providerId; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return String.format("%s - %s (%.2f€ - %dmin)", name, category, price, duration);
    }
}
