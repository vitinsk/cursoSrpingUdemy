package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.services.DBService;
import com.example.demo.services.EmailService;
import com.example.demo.services.SmtpEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	@Autowired
	private DBService dbService;

	@Bean
	public boolean instantiateDatabase() throws Exception {
		dbService.instantiateTesteDatabase();
		return true;

	}

	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
	
	
}
