package com.masai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.masai.Service.EmailSender.EmailSenderService;

@SpringBootApplication
public class CabMateApplication {
	


	public static void main(String[] args) {
		SpringApplication.run(CabMateApplication.class, args);
	}
	
	

}
