package fridaytcbd.flavorista.facade;

import fridaytcbd.flavorista.entities.Cart;
import fridaytcbd.flavorista.entities.CartItem;
import fridaytcbd.flavorista.entities.MenuItem;
import fridaytcbd.flavorista.strategy.DiscountStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CheckoutFacadeTest {

    @Mock
    private DiscountStrategy discountStrategy;

    @Test
    void shouldCalculateSubtotal() {
        CheckoutFacade checkoutFacade =
                new CheckoutFacade(discountStrategy);

        Cart cart = new Cart();

        cart.addItem(
                new CartItem(
                        new MenuItem("Pizza", 500.0),
                        2
                )
        );

        assertEquals(
                1000.0,
                checkoutFacade.calculateSubtotal(cart)
        );
    }

    @Test
    void shouldCalculateDiscountUsingMockedStrategy() {
        CheckoutFacade checkoutFacade =
                new CheckoutFacade(discountStrategy);

        Cart cart = new Cart();

        cart.addItem(
                new CartItem(
                        new MenuItem("Pizza", 500.0),
                        2
                )
        );

        when(discountStrategy.calculateDiscount(1000.0))
                .thenReturn(100.0);

        double result = checkoutFacade.calculateDiscount(cart);

        assertEquals(100.0, result);

        verify(discountStrategy)
                .calculateDiscount(1000.0);
    }

    @Test
    void shouldCalculateFinalTotalUsingMockedStrategy() {
        CheckoutFacade checkoutFacade =
                new CheckoutFacade(discountStrategy);

        Cart cart = new Cart();

        cart.addItem(
                new CartItem(
                        new MenuItem("Pizza", 500.0),
                        2
                )
        );

        when(discountStrategy.calculateFinalPrice(1000.0))
                .thenReturn(900.0);

        double result = checkoutFacade.calculateFinalTotal(cart);

        assertEquals(900.0, result);

        verify(discountStrategy)
                .calculateFinalPrice(1000.0);
    }

    @Test
    void shouldReturnZeroWhenCartIsNullForSubtotal() {
        CheckoutFacade checkoutFacade =
                new CheckoutFacade(discountStrategy);

        assertEquals(
                0.0,
                checkoutFacade.calculateSubtotal(null)
        );
    }

    @Test
    void shouldReturnZeroWhenCartIsNullForDiscount() {
        CheckoutFacade checkoutFacade =
                new CheckoutFacade(discountStrategy);

        assertEquals(
                0.0,
                checkoutFacade.calculateDiscount(null)
        );

        verifyNoInteractions(discountStrategy);
    }

    @Test
    void shouldReturnZeroWhenCartIsNullForFinalTotal() {
        CheckoutFacade checkoutFacade =
                new CheckoutFacade(discountStrategy);

        assertEquals(
                0.0,
                checkoutFacade.calculateFinalTotal(null)
        );

        verifyNoInteractions(discountStrategy);
    }

    @Test
    void shouldReturnZeroWhenDiscountStrategyIsNull() {
        CheckoutFacade checkoutFacade =
                new CheckoutFacade(null);

        Cart cart = new Cart();

        cart.addItem(
                new CartItem(
                        new MenuItem("Burger", 300.0),
                        1
                )
        );

        assertEquals(
                0.0,
                checkoutFacade.calculateDiscount(cart)
        );
    }

    @Test
    void shouldReturnSubtotalWhenDiscountStrategyIsNull() {
        CheckoutFacade checkoutFacade =
                new CheckoutFacade(null);

        Cart cart = new Cart();

        cart.addItem(
                new CartItem(
                        new MenuItem("Burger", 300.0),
                        2
                )
        );

        assertEquals(
                600.0,
                checkoutFacade.calculateFinalTotal(cart)
        );
    }
}
