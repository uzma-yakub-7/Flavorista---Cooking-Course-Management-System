package fridaytcbd.flavorista.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestControllerTest {

    private final TestController controller = new TestController();

    @Test
    void homeShouldReturnRunningMessage() {
        String result = controller.home();

        assertEquals("Flavorista is Running!", result);
    }

    @Test
    void helloShouldReturnAdminMessage() {
        String result = controller.hello();

        assertEquals("Hello from Flavorista Admin Panel!", result);
    }
}
