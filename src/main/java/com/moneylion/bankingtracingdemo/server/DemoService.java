package com.moneylion.bankingtracingdemo.server;

import com.moneylion.bankingtracingdemo.DemoEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.gateway.EventGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class DemoService {

    private final EventGateway eventGateway;

    public void sendEvent(UUID id) {
        eventGateway.publish(new DemoEvent(id));
        log.info("published event with id {}", id);
    }


}
