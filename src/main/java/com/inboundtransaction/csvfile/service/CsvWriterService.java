package com.inboundtransaction.csvfile.service;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.inboundtransaction.csvfile.model.InboundTransaction;
import com.inboundtransaction.csvfile.repository.InboundTransactionRepo;

@Service
public class CsvWriterService {
	
	@Autowired
	private InboundTransactionRepo inboundTransactionRepo;
	
	
	public void writeModelToSCV(List<InboundTransaction> inboundTransactionsList, String filename )throws IOException {
		 
//		String space = "_";
//		String csvExtention = ".csv";
		
//		filename=space +csvExtention;
		
				getAttachedFileUpdated() ;
		
		List<String> headers = new ArrayList<>() ;
		
		
		FileWriter out = new FileWriter(filename);
		
		String temp;
		
//		set the header values
		
		for(Field field : InboundTransaction.class.getDeclaredFields()) {
			
			temp = formatHeader(field.getName());
			headers.add(temp);
			
		}
		
		try(CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
				.withHeader(headers.toArray(new String[headers.size()])))){
			

			for(InboundTransaction inBoundTrans : inboundTransactionsList)
				
//				write records to cvs file
				
				printer.printRecord(
						inBoundTrans.getId(),inBoundTrans.getTransactionTypeDescription(),
						inBoundTrans.getRequesterIdNumber(),inBoundTrans.getRequesterCustomerName(), inBoundTrans.getRequesterMobileNumber(),
						inBoundTrans.getBankAcountName(), inBoundTrans.getBankAcountNumber(), inBoundTrans.getBankAcountType(),
						inBoundTrans.getRequesterSessionId(), inBoundTrans.getRequesterCellNetwork(),
						inBoundTrans.getInsurancePolicyNumberProvided(), inBoundTrans.getInsurancePolicyNumber(), inBoundTrans.getWithdrawalType(), 
						inBoundTrans.getWithdrawalAmount(), inBoundTrans.getWithdrawalFundType(), inBoundTrans.getDeceasedIdNumber(), 
						inBoundTrans.getChannel(), inBoundTrans.getEmailDispatchStatus(), inBoundTrans.getRequesterTermsConditions(),
						inBoundTrans.getCreatedAt(), inBoundTrans.getUpdatedAt());
	
					
		}
		
	}
	
	
	
	
	
	public String formatHeader(String header) {
		String result = "";
		for(int i = 0; i < header.length(); i++)
		{
			if(i==0) {
				
				result += Character.toUpperCase(header.charAt(i));
		
			}
			
			else if(Character.isUpperCase(header.charAt(i))){
				result += "_";
				
				result +=header.charAt(i);
			}
			else {
				
				result += header.charAt(i);
			}
			
			}
				return result;
		}
	
	public String getAttachedFileUpdated() {
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
			
			
			return df.format(dateobj);
	}
	
}
