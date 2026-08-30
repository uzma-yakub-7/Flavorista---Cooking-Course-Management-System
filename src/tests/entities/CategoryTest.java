package fridaytcbd.flavorista.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void shouldCreateCategoryWithConstructor() {
        Category category = new Category(1L, "Desserts");

        assertEquals(1L, category.getId());
        assertEquals("Desserts", category.getName());
    }

    @Test
    void shouldCreateCategoryWithNameOnly() {
        Category category = new Category("Main Course");

        assertNull(category.getId());
        assertEquals("Main Course", category.getName());
    }

    @Test
    void shouldSetAndGetId() {
        Category category = new Category();

        category.setId(10L);

        assertEquals(10L, category.getId());
    }

    @Test
    void shouldSetAndGetName() {
        Category category = new Category();

        category.setName("Drinks");

        assertEquals("Drinks", category.getName());
    }

    @Test
    void shouldAllowNullValues() {
        Category category = new Category();

        category.setId(null);
        category.setName(null);

        assertNull(category.getId());
        assertNull(category.getName());
    }
}
