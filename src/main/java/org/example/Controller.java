package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/api/public")
    public String publicApi() {
        return "Success - open api endpoint!";
    }

    @GetMapping("/api/protected")
    public String protectApi() {
        return "Success - protected api endpoint accessed!";
    }

    @GetMapping("/api/internal")
    public String internalApi() {
        return "Success - internal api endpoint accessed for ROLE_INTERNAL";
    }

    @GetMapping("/api/newrole")
    public String newRoleApi() {
        return "Success - api endpoint accessed for ROLE_NEWROLE";
    }
}
