package com.nit.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableTransactionManagement
@Slf4j
@EnableFeignClients
public class EmployeeServiceApplication{ // implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	/*
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void run(String... args) throws Exception {
		QuoteObj obj = restTemplate.getForObject("https://dummyjson.com/quotes", QuoteObj.class);
		log.info("Quote Object is : {}",obj);
	}
	*/
}
