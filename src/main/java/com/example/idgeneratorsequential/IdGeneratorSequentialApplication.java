package com.example.idgeneratorsequential;

import com.example.idgeneratorsequential.Service.IdGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class IdGeneratorSequentialApplication {

	@Autowired
	IdGeneratorService idGeneratorService;

	public static void main(String[] args) {
		SpringApplication.run(IdGeneratorSequentialApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	void init() {
		idGeneratorService.getCOUNTER();
	}

}
