package com.moneylion.bankingtracingdemo.client;

import com.moneylion.bankingtracingdemo.DemoEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DemoEventHandler {

    private final DemoWebService demoWebService;
    
    @EventHandler
    public void on(DemoEvent event) {
        log.info("Received event for id {}", event.getId());
        demoWebService.sendRequest();
    }

}
