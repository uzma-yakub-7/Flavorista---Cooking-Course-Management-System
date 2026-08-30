package fridaytcbd.flavorista.entities;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FavoriteTest {

    @Test
    void shouldCreateFavoriteWithFullConstructor() {
        LocalDateTime createdAt = LocalDateTime.of(2026, 8, 30, 20, 0);

        Favorite favorite = new Favorite(
                1L,
                10L,
                20L,
                30L,
                createdAt
        );

        assertEquals(1L, favorite.getId());
        assertEquals(10L, favorite.getUserId());
        assertEquals(20L, favorite.getRestaurantId());
        assertEquals(30L, favorite.getMenuItemId());
        assertEquals(createdAt, favorite.getCreatedAt());
    }

    @Test
    void shouldCreateFavoriteWithBasicConstructor() {
        Favorite favorite = new Favorite(
                10L,
                20L,
                30L
        );

        assertNull(favorite.getId());
        assertEquals(10L, favorite.getUserId());
        assertEquals(20L, favorite.getRestaurantId());
        assertEquals(30L, favorite.getMenuItemId());
        assertNotNull(favorite.getCreatedAt());
    }

    @Test
    void shouldSetAndGetId() {
        Favorite favorite = new Favorite();

        favorite.setId(5L);

        assertEquals(5L, favorite.getId());
    }

    @Test
    void shouldSetAndGetUserId() {
        Favorite favorite = new Favorite();

        favorite.setUserId(15L);

        assertEquals(15L, favorite.getUserId());
    }

    @Test
    void shouldSetAndGetRestaurantId() {
        Favorite favorite = new Favorite();

        favorite.setRestaurantId(25L);

        assertEquals(25L, favorite.getRestaurantId());
    }

    @Test
    void shouldSetAndGetMenuItemId() {
        Favorite favorite = new Favorite();

        favorite.setMenuItemId(35L);

        assertEquals(35L, favorite.getMenuItemId());
    }

    @Test
    void shouldSetAndGetCreatedAt() {
        Favorite favorite = new Favorite();

        LocalDateTime date = LocalDateTime.of(2026, 9, 1, 10, 30);

        favorite.setCreatedAt(date);

        assertEquals(date, favorite.getCreatedAt());
    }

    @Test
    void shouldCreateTimestampAutomatically() {
        Favorite favorite = new Favorite();

        assertNotNull(favorite.getCreatedAt());
    }

    @Test
    void shouldAllowNullValues() {
        Favorite favorite = new Favorite();

        favorite.setId(null);
        favorite.setUserId(null);
        favorite.setRestaurantId(null);
        favorite.setMenuItemId(null);
        favorite.setCreatedAt(null);

        assertNull(favorite.getId());
        assertNull(favorite.getUserId());
        assertNull(favorite.getRestaurantId());
        assertNull(favorite.getMenuItemId());
        assertNull(favorite.getCreatedAt());
    }
}
