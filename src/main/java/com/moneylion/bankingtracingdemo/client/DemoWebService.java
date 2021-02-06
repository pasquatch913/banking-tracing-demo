package com.moneylion.bankingtracingdemo.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class DemoWebService {

    private final WebClient client;

    public void sendRequest() {
        client.post()
                .uri("/response")
                .retrieve()
                .bodyToMono(String.class)
                .subscribe();
    }

}
