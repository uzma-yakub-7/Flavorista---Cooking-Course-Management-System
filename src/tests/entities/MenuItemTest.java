package fridaytcbd.flavorista.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemTest {

    @Test
    void constructorShouldSetValues() {
        MenuItem item = new MenuItem(1L, "Chicken Pasta", 350.0);

        assertEquals(1L, item.getId());
        assertEquals("Chicken Pasta", item.getName());
        assertEquals(350.0, item.getPrice());
    }

    @Test
    void settersShouldUpdateValues() {
        MenuItem item = new MenuItem();

        item.setId(2L);
        item.setName("Chocolate Cake");
        item.setPrice(250.0);

        assertEquals(2L, item.getId());
        assertEquals("Chocolate Cake", item.getName());
        assertEquals(250.0, item.getPrice());
    }

    @Test
    void constructorWithoutIdShouldWork() {
        MenuItem item = new MenuItem("Beef Burger", 450.0);

        assertEquals("Beef Burger", item.getName());
        assertEquals(450.0, item.getPrice());
    }
}
