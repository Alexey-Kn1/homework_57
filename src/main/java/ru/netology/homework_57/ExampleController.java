package ru.netology.homework_57;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ExampleController {
    @GetMapping("endpoint0")
    public String endpoint0() {
        return "endpoint0";
    }

    @GetMapping("endpoint1")
    public String endpoint1() {
        return "endpoint1";
    }

    @GetMapping("endpoint2")
    public String endpoint2() {
        return "endpoint2";
    }

    @GetMapping("endpoint3")
    public String endpoint3() {
        return "endpoint3";
    }
}
