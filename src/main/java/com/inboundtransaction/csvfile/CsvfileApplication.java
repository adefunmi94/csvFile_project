package com.inboundtransaction.csvfile;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.inboundtransaction.csvfile.model.InboundTransaction;
import com.inboundtransaction.csvfile.repository.InboundTransactionRepo;
import com.inboundtransaction.csvfile.service.CsvWriterService;
import com.inboundtransaction.csvfile.service.EmailService;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class CsvfileApplication {
	@Autowired
	private CsvWriterService csvWritterServ;
	
	@Autowired
	private EmailService emailServiceImp;
	
	@Autowired
	private InboundTransactionRepo inboundTransRepo;



	public static void main(String[] args) {
		SpringApplication.run(CsvfileApplication.class, args);
	}

		
}
