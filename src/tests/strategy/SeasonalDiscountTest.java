package fridaytcbd.flavorista.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeasonalDiscountTest {

    @Test
    void shouldReturnFifteenPercentDiscount() {
        SeasonalDiscount discount = new SeasonalDiscount();

        assertEquals(0.15, discount.getDiscountPercentage());
    }

    @Test
    void shouldCalculateDiscount() {
        SeasonalDiscount discount = new SeasonalDiscount();

        assertEquals(150.0, discount.calculateDiscount(1000.0));
    }

    @Test
    void shouldCalculateFinalPrice() {
        SeasonalDiscount discount = new SeasonalDiscount();

        assertEquals(850.0, discount.calculateFinalPrice(1000.0));
    }

    @Test
    void shouldReturnZeroForZeroSubtotal() {
        SeasonalDiscount discount = new SeasonalDiscount();

        assertEquals(0.0, discount.calculateDiscount(0.0));
        assertEquals(0.0, discount.calculateFinalPrice(0.0));
    }
}
