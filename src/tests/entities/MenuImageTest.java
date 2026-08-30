package fridaytcbd.flavorista.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuImageTest {

    @Test
    void shouldCreateMenuImageUsingEmptyConstructor() {
        MenuImage image = new MenuImage();

        assertNotNull(image);
        assertNull(image.getId());
        assertNull(image.getImageUrl());
        assertNull(image.getAltText());
        assertFalse(image.isPrimary());
    }

    @Test
    void shouldCreateMenuImageUsingFullConstructor() {
        MenuImage image = new MenuImage(
                1L,
                "https://example.com/pasta.jpg",
                "Creamy pasta",
                true
        );

        assertEquals(1L, image.getId());
        assertEquals("https://example.com/pasta.jpg", image.getImageUrl());
        assertEquals("Creamy pasta", image.getAltText());
        assertTrue(image.isPrimary());
    }

    @Test
    void shouldCreateMenuImageUsingShortConstructor() {
        MenuImage image = new MenuImage(
                "https://example.com/pizza.jpg",
                "Delicious pizza",
                false
        );

        assertNull(image.getId());
        assertEquals("https://example.com/pizza.jpg", image.getImageUrl());
        assertEquals("Delicious pizza", image.getAltText());
        assertFalse(image.isPrimary());
    }

    @Test
    void shouldSetAndGetId() {
        MenuImage image = new MenuImage();

        image.setId(10L);

        assertEquals(10L, image.getId());
    }

    @Test
    void shouldSetAndGetImageUrl() {
        MenuImage image = new MenuImage();

        image.setImageUrl("images/burger.jpg");

        assertEquals("images/burger.jpg", image.getImageUrl());
    }

    @Test
    void shouldSetAndGetAltText() {
        MenuImage image = new MenuImage();

        image.setAltText("Chicken burger");

        assertEquals("Chicken burger", image.getAltText());
    }

    @Test
    void shouldSetPrimaryStatus() {
        MenuImage image = new MenuImage();

        image.setPrimary(true);

        assertTrue(image.isPrimary());

        image.setPrimary(false);

        assertFalse(image.isPrimary());
    }
}
