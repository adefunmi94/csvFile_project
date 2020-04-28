package com.inboundtransaction.csvfile.service;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
	
	
	@Autowired
	private JavaMailSender emailSender;
	
	
	@Override
	public void sendSimpleMessage(String to, String subject, String text) throws RuntimeException {
		// TODO Auto-generated method stub
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		
		try {
			emailSender.send(message);
		}catch(RuntimeException e) {
			
			throw e;
			
		}
	}
	
	@Override
	public void sendWithAttatchMent(String to, String subject, String text, 
			String pathToAttachment, String extensionName) throws MessagingException{
			
		 
		String space = "_";
		String filena = ".csv";
		String extendName = "transactions";
		extensionName = extendName + space + getAttachedFileUpdated() + filena;
		
		MimeMessage message = emailSender.createMimeMessage();
	      
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	     
	    helper.setTo(to);
	    helper.setSubject(subject);
	    helper.setText(text);
	         
	    FileSystemResource file 
	      = new FileSystemResource(new File(pathToAttachment));
	    helper.addAttachment(extensionName, file);
	 
	    emailSender.send(message);
	}
	
	public String getAttachedFileUpdated() {
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
			return df.format(dateobj);
	}
}
