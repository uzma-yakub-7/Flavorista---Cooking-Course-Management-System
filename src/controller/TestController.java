package fridaytcbd.flavorista.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "Flavorista is Running!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Flavorista Admin Panel!";
    }
}