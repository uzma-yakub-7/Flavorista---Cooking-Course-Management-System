package fridaytcbd.flavorista.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularDiscountTest {

    @Test
    void shouldReturnFivePercentDiscount() {
        RegularDiscount discount = new RegularDiscount();

        assertEquals(0.05, discount.getDiscountPercentage());
    }

    @Test
    void shouldCalculateDiscount() {
        RegularDiscount discount = new RegularDiscount();

        assertEquals(50.0, discount.calculateDiscount(1000.0));
    }

    @Test
    void shouldCalculateFinalPrice() {
        RegularDiscount discount = new RegularDiscount();

        assertEquals(950.0, discount.calculateFinalPrice(1000.0));
    }

    @Test
    void shouldReturnZeroForZeroSubtotal() {
        RegularDiscount discount = new RegularDiscount();

        assertEquals(0.0, discount.calculateDiscount(0.0));
        assertEquals(0.0, discount.calculateFinalPrice(0.0));
    }

    @Test
    void shouldReturnZeroForNegativeSubtotal() {
        RegularDiscount discount = new RegularDiscount();

        assertEquals(0.0, discount.calculateDiscount(-100.0));
        assertEquals(0.0, discount.calculateFinalPrice(-100.0));
    }
}
