package fridaytcbd.flavorista.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final List<CartItem> items = new ArrayList<>();

    public void addItem(CartItem item) {
        if (item != null) {
            items.add(item);
        }
    }

    public void removeItem(CartItem item) {
        items.remove(item);
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getSubtotal() {
        double subtotal = 0.0;

        for (CartItem item : items) {
            if (item != null) {
                subtotal += item.getTotalPrice();
            }
        }

        return subtotal;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }
}
