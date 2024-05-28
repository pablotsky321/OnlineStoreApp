package org.service.microservicecliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceClienteApplication.class, args);
	}

}
