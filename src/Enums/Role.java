package Enums;

public enum Role {
    MANAGER("Store Manager"),
    SALES_ASSOCIATE("Sales Associate"),
    CASHIER("Cashier"),
    INVENTORY_CLERK("Inventory Clerk"),
    MUSIC_EXPERT("Music Expert"),
    SECURITY("Security Guard");

    private final String title;

    Role(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
