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


@SpringBootApplication
public class CsvfileApplication implements Runnable{
	@Autowired
	private CsvWriterService csvWritterServ;
	
	@Autowired
	private EmailService emailServiceImp;
	
	@Autowired
	private InboundTransactionRepo inboundTransRepo;



	public static void main(String[] args) {
		SpringApplication.run(CsvfileApplication.class, args);
	}



	@Override
	public void run() {
		Runnable td = new CsvfileApplication();
		
		Thread thread = new Thread(td); 
		
		
		
		List<InboundTransaction> getTransaction = inboundTransRepo.findByEmailDispatchStatus("0");
		
		for(InboundTransaction inbouTrans : getTransaction) {
			inbouTrans.setEmailDispatchStatus("1");
			inboundTransRepo.save(inbouTrans);
			
			thread.start();
		}
		try {
			csvWritterServ.writeModelToSCV(getTransaction, "inboundtrans2.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			emailServiceImp.sendWithAttatchMent("oyeyipoadefunmi90@gmail.com", "CSV Project", "Hello Funmi, \n Hope this email meet u well.\n Kindly see the attached of csv file i worked, I am just testing  it. \n   Thanks \n Funmilayo", "inboundtrans2.csv", "transactions");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			for(InboundTransaction inboundTrans: getTransaction) {
			
					System.out.println("check" + inboundTrans);
			
					inboundTrans.setEmailDispatchStatus("2");
					
					inboundTransRepo.save(inboundTrans);
			}
			
//						getTransaction= inboundTransRepo.findByEmailDispatchStatus("2");
						
//						for(InboundTransaction inboundTrans: getTransaction) {
			
								
			try {
				thread.wait(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
								
			
			
//						}


	}
		
}
