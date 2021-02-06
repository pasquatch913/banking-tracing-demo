package com.moneylion.bankingtracingdemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class BankingTracingDemoApplicationTests extends TestcontainersConfig {

	private WebTestClient client;

	@BeforeEach
	public void setup() {
		client = WebTestClient
				.bindToServer()
				.baseUrl("http://localhost:8080")
				.build();
	}

	@Test
	void contextLoads() throws InterruptedException {
		client.post()
				.uri("/response")
				.exchange()
				.expectStatus().isOk();

		Thread.sleep(500);
	}

}
