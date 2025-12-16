package domain.entities;

/**
 * Client - utilisateur qui réserve des services.
 * Applique LSP : peut être substitué à User sans problème.
 */
public class Client extends User {
    private String address;
    private String phone;

    public Client(String id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public Client(String id, String name, String email, String password, String address, String phone) {
        super(id, name, email, password);
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String getRole() {
        return "CLIENT";
    }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
