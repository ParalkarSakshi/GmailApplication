package com.example.gmail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.gmail.models.Emails;



@RestController
public class EmailApplication {
	
		// JavaMailSender :- it is dependency
		//  @Autowired :- Connected to classes
	
	 @Autowired
	 private JavaMailSender javaMailSender; 
	 
	 @PostMapping("/s")
		public String sendEmail(@RequestBody Emails emailRequest) {
			
			SimpleMailMessage message = new SimpleMailMessage();
			
			message.setFrom("sakshiparalkar1@gmail.com");
			message.setTo(emailRequest.getTo());
			message.setSubject(emailRequest.getSubject());
			message.setText(emailRequest.getBody());
			
			javaMailSender.send(message);
			
			return "Email sent successfully";
		}
}
