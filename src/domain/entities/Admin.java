package domain.entities;

/**
 * Admin - utilisateur avec privilèges administrateur.
 * Applique LSP : peut être substitué à User sans problème.
 */
public class Admin extends User {
    private String department;

    public Admin(String id, String name, String email, String password, String department) {
        super(id, name, email, password);
        this.department = department;
    }

    @Override
    public String getRole() {
        return "ADMIN";
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}
