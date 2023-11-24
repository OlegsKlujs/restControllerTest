package de.ipu.restControllerTest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class TestRoles {

    @Secured("ROLE_VIEWER")
    public String getUsername() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return securityContext.getAuthentication().getName();
    }

    @Secured({ "ROLE_VIEWER", "ROLE_EDITOR" })
    public boolean isValidUsername(String username) {
        return username.contains("Masha");
    }

    @PreAuthorize("hasRole('ROLE_VIEWER')")
    public String getUsernameInUpperCase() {
        return getUsername().toUpperCase();
    }
}
