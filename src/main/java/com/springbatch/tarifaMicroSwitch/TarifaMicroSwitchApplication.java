package com.springbatch.tarifaMicroSwitch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TarifaMicroSwitchApplication {

	public static void main(String[] args) {
		SpringApplication.run(TarifaMicroSwitchApplication.class, args);
	}

}
