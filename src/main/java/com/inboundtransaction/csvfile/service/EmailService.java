package com.inboundtransaction.csvfile.service;

import javax.mail.MessagingException;

public interface EmailService {

	public void sendSimpleMessage(String to, String subject, String text);
	
	public void sendWithAttatchMent(String to, String subject, String text, String pathToAttatchMent, String exteString) throws MessagingException;
	
}
