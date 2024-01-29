package net.ilyass.accountservice.controllers;


import lombok.AllArgsConstructor;
import net.ilyass.accountservice.config.ConfigParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class TestConfig {
    @Value("${global.params.p1}")
    private int p1;
    @Value("${global.params.p2}")
    private int p2;
    @Value("${account.params.a}")
    private int a;
    @Value("${account.params.b}")
    private int b;
    @Autowired
    private ConfigParams configParams;

    @GetMapping("/config")
    Map<String, Integer> getAccountConfig() {
        return Map.of("p1", p1, "p2", p2, "a", a, "b", b);
    }

    @GetMapping("/configparam")
    ConfigParams getConfigParams() {
        return configParams;
    }
}
