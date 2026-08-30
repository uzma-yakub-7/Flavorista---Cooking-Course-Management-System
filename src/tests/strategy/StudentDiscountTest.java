package fridaytcbd.flavorista.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentDiscountTest {

    @Test
    void shouldReturnTenPercentDiscount() {
        StudentDiscount discount = new StudentDiscount();

        assertEquals(0.10, discount.getDiscountPercentage());
    }

    @Test
    void shouldCalculateDiscount() {
        StudentDiscount discount = new StudentDiscount();

        assertEquals(100.0, discount.calculateDiscount(1000.0));
    }

    @Test
    void shouldCalculateFinalPrice() {
        StudentDiscount discount = new StudentDiscount();

        assertEquals(900.0, discount.calculateFinalPrice(1000.0));
    }

    @Test
    void shouldReturnZeroForZeroSubtotal() {
        StudentDiscount discount = new StudentDiscount();

        assertEquals(0.0, discount.calculateDiscount(0.0));
        assertEquals(0.0, discount.calculateFinalPrice(0.0));
    }
}
