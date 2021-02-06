package com.moneylion.bankingtracingdemo;

import com.moneylion.banking.logging.EnableLogging;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableLogging
@SpringBootApplication
public class BankingTracingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingTracingDemoApplication.class, args);
	}

}
