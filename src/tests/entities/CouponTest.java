package fridaytcbd.flavorista.entities;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CouponTest {

    @Test
    void shouldCreateCouponWithFullConstructor() {
        LocalDate expiryDate = LocalDate.of(2026, 12, 31);

        Coupon coupon = new Coupon(
                1L,
                "SAVE10",
                10.0,
                expiryDate,
                true
        );

        assertEquals(1L, coupon.getId());
        assertEquals("SAVE10", coupon.getCode());
        assertEquals(10.0, coupon.getDiscountPercentage());
        assertEquals(expiryDate, coupon.getExpiryDate());
        assertTrue(coupon.isActive());
    }

    @Test
    void shouldCreateCouponWithCodeConstructor() {
        LocalDate expiryDate = LocalDate.of(2026, 12, 31);

        Coupon coupon = new Coupon(
                "SAVE15",
                15.0,
                expiryDate
        );

        assertNull(coupon.getId());
        assertEquals("SAVE15", coupon.getCode());
        assertEquals(15.0, coupon.getDiscountPercentage());
        assertEquals(expiryDate, coupon.getExpiryDate());
        assertTrue(coupon.isActive());
    }

    @Test
    void shouldSetAndGetId() {
        Coupon coupon = new Coupon();

        coupon.setId(5L);

        assertEquals(5L, coupon.getId());
    }

    @Test
    void shouldSetAndGetCode() {
        Coupon coupon = new Coupon();

        coupon.setCode("FLAVOR20");

        assertEquals("FLAVOR20", coupon.getCode());
    }

    @Test
    void shouldSetAndGetDiscountPercentage() {
        Coupon coupon = new Coupon();

        coupon.setDiscountPercentage(20.0);

        assertEquals(20.0, coupon.getDiscountPercentage());
    }

    @Test
    void shouldSetAndGetExpiryDate() {
        Coupon coupon = new Coupon();

        LocalDate expiryDate = LocalDate.of(2027, 1, 15);
        coupon.setExpiryDate(expiryDate);

        assertEquals(expiryDate, coupon.getExpiryDate());
    }

    @Test
    void shouldSetActiveStatus() {
        Coupon coupon = new Coupon();

        assertTrue(coupon.isActive());

        coupon.setActive(false);

        assertFalse(coupon.isActive());
    }

    @Test
    void shouldAllowNullValues() {
        Coupon coupon = new Coupon();

        coupon.setId(null);
        coupon.setCode(null);
        coupon.setExpiryDate(null);

        assertNull(coupon.getId());
        assertNull(coupon.getCode());
        assertNull(coupon.getExpiryDate());
    }
}
