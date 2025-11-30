package ru.netology.homework_57;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity (
        prePostEnabled = true,
        securedEnabled = true,
        mode = AdviceMode.PROXY,
        jsr250Enabled = true
)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
