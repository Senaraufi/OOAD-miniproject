/**
 * Enumeration of employee roles in the music shop.
 * Defines job positions and their associated display titles.
 * 
 * Key features:
 * - Role-based access control
 * - Human-readable role titles
 * - Hierarchical organization structure
 * 
 * Design Pattern: Role Pattern
 * - Encapsulates role-specific behavior
 * - Supports role-based permissions
 * 
 * @see Employee
 * @see EmployeeRosterGUI
 */
package Enums;

public enum Role {
    /**
     * Store manager with highest authority level
     */
    MANAGER("Store Manager"),
    
    /**
     * Sales associate for customer service
     */
    SALES_ASSOCIATE("Sales Associate"),
    
    /**
     * Inventory clerk for stock management
     */
    INVENTORY_CLERK("Inventory Clerk"),
    
    /**
     * Cashier for transaction processing
     */
    CASHIER("Cashier"),
    
    /**
     * Music expert for customer consultation
     */
    MUSIC_EXPERT("Music Expert"),
    
    /**
     * Security guard for store safety
     */
    SECURITY("Security Guard");

    /** The display title for this role */
    private final String title;

    /**
     * Constructs a new Role with the specified display title.
     * 
     * @param title The human-readable title for this role
     */
    Role(String title) {
        this.title = title;
    }

    /**
     * Gets the display title of this role.
     * 
     * @return The human-readable title for this role
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the string representation of this role.
     * 
     * @return The display title of this role
     */
    @Override
    public String toString() {
        return title;
    }
}
