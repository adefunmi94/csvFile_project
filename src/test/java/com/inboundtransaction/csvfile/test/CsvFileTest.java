package com.inboundtransaction.csvfile.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.transaction.Transaction;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.inboundtransaction.csvfile.model.InboundTransaction;
import com.inboundtransaction.csvfile.repository.InboundTransactionRepo;
import com.inboundtransaction.csvfile.service.CsvWriterService;
import com.inboundtransaction.csvfile.service.EmailService;

@SpringBootTest
@Sql(scripts = {"classpath:/db/inbound-transaction-script.sql"})
public class CsvFileTest {
	
	@Autowired
	private EmailService emailServiceImpl;

	@Autowired
	private CsvWriterService csvWritterServ;
	
	@Autowired
	private InboundTransactionRepo inboundTransactionRepo;
		
		Map<String, String> AUTHOR_BOOK_MAP = new HashMap<>();
		
		String[] HEADERS = {"author", "title"};
		
		String[] HEADERS1 = {"Bank name", "Bank Number"};
		
		
		@BeforeEach
		public void setUp() {
			
//			AUTHOR_BOOK_MAP.put("Dan Simmons", "Hyperion");
//	        AUTHOR_BOOK_MAP.put("Douglas Adams", "The Hitchhiker's Guide to the Galaxy");
	        
	        assertNotNull(csvWritterServ);
	        assertNotNull(inboundTransactionRepo);
	        
		}
	
		@Test
		public void readFromCvs() throws IOException{
			Reader in = new FileReader("book.csv");
		
			Iterable<CSVRecord> records = CSVFormat.DEFAULT
					.withHeader(HEADERS)
					.withFirstRecordAsHeader()
					.parse(in);
			
			for(CSVRecord record: records) {
				
				System.out.println(record);
				
				String author = record.get("author");
				String title = record.get("title");
				
				System.out.println(author+"  "+ title);
				System.out.println(AUTHOR_BOOK_MAP.get(author));
//				assertEquals(AUTHOR_BOOK_MAP.get(author), title); 	
				
			}
		}
			
		@Test
		public void createCsvFile() throws IOException {
			FileWriter out = new FileWriter("book_new.csv");
			
			
			try (CSVPrinter printer  = new  CSVPrinter(out, CSVFormat.DEFAULT
						.withHeader(HEADERS))){ 
				
					AUTHOR_BOOK_MAP.forEach((author, title) -> {
						
						try {
							printer.printRecord(author, title);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				});
			}
		}
		
		@Test
		public void writeModelToCSV() throws IOException {
			
			List<InboundTransaction> inboundTrans = inboundTransactionRepo.findAll();
			csvWritterServ.writeModelToSCV(inboundTrans, "inbound-trasactions.csv");
			
		}
			
		
		public String formatHeader(String header) {
			
			String result = "";
			
			for(int i = 0; i < header.length(); i++) {
				
				if(i == 0) {
					result += Character.toUpperCase(header.charAt(i));
				}
				else if(Character.isUpperCase(header.charAt(i))) {
					result+='-';
					result+=header.charAt(i);
				}
				else {
					result += header.charAt(i);
				}
				
			}
			return result;
		}
		
		
		@Test
		public  void getObejectFromDbTest(){
			
			
//			assertNotNull(csvWritterServ);
			
			List<InboundTransaction> savedTransaction= inboundTransactionRepo.findAll();
			
			for(InboundTransaction transaction: savedTransaction) {
				
				assertNotNull(transaction);
			}
		
		}
		
		@Test
		public void configEmailTest() {
			
			assertNotNull(emailServiceImpl);
			
			try {
				emailServiceImpl.sendSimpleMessage("oyeyipoadefunmi90@gmail.com", "csv project", "I am just testing ");
			}
			catch(RuntimeException e) {
				e.printStackTrace();
			}
		}
		
		@Test
		public void sendEmailWithAttatchMentTest() {
			
			assertNotNull(emailServiceImpl);
			
			try {
				emailServiceImpl.sendWithAttatchMent("oyeyipoadefunmi90@gmail.com", 
						"csv project", "I am just testing ", "inbound-transaction.csv", "transaction.csv");
			}
			catch(MessagingException e) {
				e.printStackTrace();
			}
		}
		
		
		@Test
		public  void getObejecByEmailDispatchStatus() throws IOException{
			//fetch record with email status of 0
			List<InboundTransaction> savedTransaction= inboundTransactionRepo.findByEmailDispatchStatus("0");
			
			assertThat(savedTransaction.size()).isEqualTo(4);
			
			for(InboundTransaction transaction: savedTransaction) {
				
				System.out.println(transaction);
				
				assertThat(transaction.getEmailDispatchStatus()).isEqualTo("0");
				
				transaction.setEmailDispatchStatus("1");
				
				inboundTransactionRepo.save(transaction);
				
			}
			
			//set email dispatch status for each record to 1 indicating picked
			
			savedTransaction= inboundTransactionRepo.findByEmailDispatchStatus("1");
				for(InboundTransaction transaction: savedTransaction) {
				
						System.out.println(transaction);
						
						assertThat(transaction.getEmailDispatchStatus()).isEqualTo("1");
						
				
				
			}
			
		
			//write records to csv file
			csvWritterServ.writeModelToSCV(savedTransaction, "inboundtrans2.csv");
			
			
			//send csv file to email address
			
			try {
//				String filename = "transactions";
//				Date today = new Date();
//				//String attachmentName = filename+today.getTime().+"..csv";
				
				emailServiceImpl.sendWithAttatchMent("oyeyipoadefunmi90@gmail.com", "CSV Project", "Hello Micheal, \n Hope this email meet u well.\n Kindly see the attached of csv file i worked, I am just testing  it. \n   Thanks \n Funmilayo", "inboundtrans2.csv", "transactions");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				for(InboundTransaction transaction: savedTransaction) {
				
						System.out.println(transaction);
				
						transaction.setEmailDispatchStatus("2");
						
						inboundTransactionRepo.save(transaction);
				}
				
							savedTransaction= inboundTransactionRepo.findByEmailDispatchStatus("2");
							for(InboundTransaction transaction: savedTransaction) {
				
									System.out.println(transaction);
									
									assertThat(transaction.getEmailDispatchStatus()).isEqualTo("2");
									
				
				
			}
		}
		
}
