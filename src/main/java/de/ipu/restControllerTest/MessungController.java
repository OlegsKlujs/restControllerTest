package de.ipu.restControllerTest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessungController {

    @GetMapping("bla")
    public String getmessung() {
        return ping();
    }

    @GetMapping("ping")
    @PreAuthorize("hasRole('ADMIN')")
    public String ping() {
        return "pong";
    }
}
