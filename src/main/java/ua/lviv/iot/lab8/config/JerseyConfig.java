package ua.lviv.iot.lab8.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import ua.lviv.iot.lab8.controller.DoorController;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(DoorController.class);
    }
}