package com.example.alura.medvolli.sapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.util.Collections;

@SpringBootApplication
public class SapiApplication {

	public static void main(String[] args) {
//		SpringApplication app = new SpringApplication(SapiApplication.class);
//		app.setDefaultProperties(Collections.singletonMap("server.port", 8085));
//		app.run(args);
		SpringApplication.run(SapiApplication.class, args);
	}

}
