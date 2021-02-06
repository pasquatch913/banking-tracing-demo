package com.moneylion.bankingtracingdemo;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@DirtiesContext
@Testcontainers
public class TestcontainersConfig {

    @Container
    public static GenericContainer axonContainer = new GenericContainer("axoniq/axonserver:latest")
            .withExposedPorts(8024, 8124)
            .waitingFor(Wait.forHttp("/actuator/health").forPort(8024))
            .withStartupTimeout(Duration.of(60L, ChronoUnit.SECONDS));

    @DynamicPropertySource
    static void setTestContainerProperties(DynamicPropertyRegistry registry) {
        registry.add("axon.axonserver.servers", () -> axonContainer.getContainerIpAddress() + ":" + axonContainer.getMappedPort(8124));
    }

}
