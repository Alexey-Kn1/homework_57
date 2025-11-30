package ru.netology.homework_57;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ExampleController {
    @GetMapping("endpoint0")
    @PreAuthorize("permitAll()")
    public String endpoint0() {
        return "endpoint0";
    }

    @GetMapping("endpoint1")
    @Secured("ROLE_READ")
    public String endpoint1() {
        return "endpoint1";
    }

    @GetMapping("endpoint2")
    @RolesAllowed({"WRITE"})
    public String endpoint2() {
        return "endpoint2";
    }

    @GetMapping("endpoint3")
    @PreAuthorize("hasRole('WRITE') or hasRole('DELETE')")
    public String endpoint3() {
        return "endpoint3";
    }

    @GetMapping("endpoint4")
    @PreAuthorize("#username == authentication.name")
    public String endpoint4(@RequestParam String username) {
        return "endpoint4, called by '" + username + "'";
    }
}
