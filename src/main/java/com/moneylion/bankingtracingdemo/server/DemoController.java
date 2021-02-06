package com.moneylion.bankingtracingdemo.server;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @PostMapping("/response")
    public Mono<ResponseEntity<String>> getResponse() {
        demoService.sendEvent(UUID.randomUUID());
        return Mono.just(ResponseEntity.ok("sent"));
    }
}
