package fridaytcbd.flavorista.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartItemTest {

    @Test
    void shouldCalculateTotalPrice() {
        MenuItem item = new MenuItem(1L, "Pizza", 500.0);
        CartItem cartItem = new CartItem(item, 2);

        assertEquals(1000.0, cartItem.getTotalPrice());
    }

    @Test
    void shouldReturnZeroForZeroQuantity() {
        MenuItem item = new MenuItem(1L, "Pizza", 500.0);
        CartItem cartItem = new CartItem(item, 0);

        assertEquals(0.0, cartItem.getTotalPrice());
    }

    @Test
    void shouldReturnZeroForNegativeQuantity() {
        MenuItem item = new MenuItem(1L, "Pizza", 500.0);
        CartItem cartItem = new CartItem(item, -1);

        assertEquals(0.0, cartItem.getTotalPrice());
    }

    @Test
    void shouldReturnZeroWhenMenuItemIsNull() {
        CartItem cartItem = new CartItem(null, 2);

        assertEquals(0.0, cartItem.getTotalPrice());
    }

    @Test
    void settersShouldUpdateValues() {
        CartItem cartItem = new CartItem();

        MenuItem item = new MenuItem("Pasta", 300.0);

        cartItem.setMenuItem(item);
        cartItem.setQuantity(3);

        assertEquals(item, cartItem.getMenuItem());
        assertEquals(3, cartItem.getQuantity());
        assertEquals(900.0, cartItem.getTotalPrice());
    }
}
