package fridaytcbd.flavorista.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void newCartShouldBeEmpty() {
        Cart cart = new Cart();

        assertTrue(cart.isEmpty());
        assertEquals(0.0, cart.getSubtotal());
    }

    @Test
    void shouldAddItemToCart() {
        Cart cart = new Cart();

        MenuItem item = new MenuItem("Burger", 300.0);
        CartItem cartItem = new CartItem(item, 2);

        cart.addItem(cartItem);

        assertFalse(cart.isEmpty());
        assertEquals(1, cart.getItems().size());
    }

    @Test
    void shouldCalculateSubtotal() {
        Cart cart = new Cart();

        MenuItem pasta = new MenuItem("Pasta", 300.0);
        MenuItem cake = new MenuItem("Cake", 200.0);

        cart.addItem(new CartItem(pasta, 2));
        cart.addItem(new CartItem(cake, 1));

        assertEquals(800.0, cart.getSubtotal());
    }

    @Test
    void shouldIgnoreNullItem() {
        Cart cart = new Cart();

        cart.addItem(null);

        assertTrue(cart.isEmpty());
        assertEquals(0.0, cart.getSubtotal());
    }

    @Test
    void shouldRemoveItem() {
        Cart cart = new Cart();

        CartItem item = new CartItem(
                new MenuItem("Burger", 300.0),
                1
        );

        cart.addItem(item);
        cart.removeItem(item);

        assertTrue(cart.isEmpty());
    }

    @Test
    void shouldClearCart() {
        Cart cart = new Cart();

        cart.addItem(
                new CartItem(
                        new MenuItem("Pizza", 500.0),
                        1
                )
        );

        cart.clear();

        assertTrue(cart.isEmpty());
        assertEquals(0.0, cart.getSubtotal());
    }
}
