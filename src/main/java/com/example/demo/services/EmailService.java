package com.example.demo.services;

import org.springframework.mail.SimpleMailMessage;

import com.example.demo.model.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}