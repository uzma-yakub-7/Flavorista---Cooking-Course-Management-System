package fridaytcbd.flavorista.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void shouldCreateAddressWithFullConstructor() {
        Address address = new Address(
                1L,
                10L,
                "Home",
                "123 Main Street",
                "Sylhet",
                "Sylhet",
                "3100",
                "Bangladesh",
                24.8949,
                91.8687,
                true
        );

        assertEquals(1L, address.getId());
        assertEquals(10L, address.getUserId());
        assertEquals("Home", address.getLabel());
        assertEquals("123 Main Street", address.getAddressLine());
        assertEquals("Sylhet", address.getCity());
        assertEquals("Sylhet", address.getState());
        assertEquals("3100", address.getPostalCode());
        assertEquals("Bangladesh", address.getCountry());
        assertEquals(24.8949, address.getLatitude());
        assertEquals(91.8687, address.getLongitude());
        assertTrue(address.isDefaultAddress());
    }

    @Test
    void shouldCreateAddressWithBasicConstructor() {
        Address address = new Address(
                10L,
                "Work",
                "456 Office Road",
                "Dhaka",
                "Dhaka",
                "1205",
                "Bangladesh"
        );

        assertNull(address.getId());
        assertEquals(10L, address.getUserId());
        assertEquals("Work", address.getLabel());
        assertEquals("456 Office Road", address.getAddressLine());
        assertEquals("Dhaka", address.getCity());
        assertEquals("Dhaka", address.getState());
        assertEquals("1205", address.getPostalCode());
        assertEquals("Bangladesh", address.getCountry());
    }

    @Test
    void shouldSetAndGetId() {
        Address address = new Address();

        address.setId(5L);

        assertEquals(5L, address.getId());
    }

    @Test
    void shouldSetAndGetUserId() {
        Address address = new Address();

        address.setUserId(20L);

        assertEquals(20L, address.getUserId());
    }

    @Test
    void shouldSetAndGetAddressInformation() {
        Address address = new Address();

        address.setLabel("Home");
        address.setAddressLine("House 10");
        address.setCity("Sylhet");
        address.setState("Sylhet");
        address.setPostalCode("3100");
        address.setCountry("Bangladesh");

        assertEquals("Home", address.getLabel());
        assertEquals("House 10", address.getAddressLine());
        assertEquals("Sylhet", address.getCity());
        assertEquals("Sylhet", address.getState());
        assertEquals("3100", address.getPostalCode());
        assertEquals("Bangladesh", address.getCountry());
    }

    @Test
    void shouldSetAndGetCoordinates() {
        Address address = new Address();

        address.setLatitude(24.8949);
        address.setLongitude(91.8687);

        assertEquals(24.8949, address.getLatitude());
        assertEquals(91.8687, address.getLongitude());
    }

    @Test
    void shouldSetDefaultAddressStatus() {
        Address address = new Address();

        assertFalse(address.isDefaultAddress());

        address.setDefaultAddress(true);

        assertTrue(address.isDefaultAddress());

        address.setDefaultAddress(false);

        assertFalse(address.isDefaultAddress());
    }

    @Test
    void shouldAllowNullTextValues() {
        Address address = new Address();

        address.setLabel(null);
        address.setAddressLine(null);
        address.setCity(null);
        address.setState(null);
        address.setPostalCode(null);
        address.setCountry(null);

        assertNull(address.getLabel());
        assertNull(address.getAddressLine());
        assertNull(address.getCity());
        assertNull(address.getState());
        assertNull(address.getPostalCode());
        assertNull(address.getCountry());
    }
}
