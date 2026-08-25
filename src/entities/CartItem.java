package fridaytcbd.flavorista.entities;

public class CartItem {

    private MenuItem menuItem;
    private int quantity;

    public CartItem() {
    }

    public CartItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        if (menuItem == null || quantity <= 0) {
            return 0.0;
        }

        return menuItem.getPrice() * quantity;
    }
}
