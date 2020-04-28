package com.inboundtransaction.csvfile.service;
/*
 *@author tobi
 * created on 28/04/2020
 *
 */

import com.inboundtransaction.csvfile.CsvfileApplication;
import com.inboundtransaction.csvfile.model.InboundTransaction;
import com.inboundtransaction.csvfile.repository.InboundTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ScheduledTasks {

    @Autowired
    private InboundTransactionRepo inboundTransRepo;

    @Autowired
    private CsvWriterService csvWritterServ;

    @Autowired
    private EmailService emailServiceImp;

    Logger logger = Logger.getLogger(getClass().getName());


    @Scheduled(fixedRate = 5000)
    public void runDatabaseScan() {

        logger.info("Method invocation started");

        List<InboundTransaction> getTransaction = inboundTransRepo.findByEmailDispatchStatus("0");

        logger.info("Fetched Transactions with email dispatch status of 0 from the database");

        if(getTransaction != null) {
            getTransaction.stream().forEach(inboundTransaction -> {

                inboundTransaction.setEmailDispatchStatus("1");
                inboundTransRepo.save(inboundTransaction);
            });

            logger.info("Email dispatch status set to 1 for transactions");


            try {

                csvWritterServ.writeModelToSCV(getTransaction, "inboundtrans2.csv");

                emailServiceImp.sendWithAttatchMent("oyeyipoadefunmi90@gmail.com",
                        "CSV Project", "Hello Funmi, \n Hope this email meet u well.\n Kindly see the attached of csv file i worked, I am just testing  it. \n   Thanks \n Funmilayo",
                        "inboundtrans2.csv",
                        "transactions");

                //Transaction status set to 2
                getTransaction.stream().forEach(inboundTransaction -> {

                    inboundTransaction.setEmailDispatchStatus("2");
                    inboundTransRepo.save(inboundTransaction);
                });

                logger.info("Email sent successfully!");

            } catch (IOException e) {

                logger.log(Level.SEVERE, "Error occured while writing files to CSV");

                e.printStackTrace();
            } catch (MessagingException e) {
                // TODO Auto-generated catch block

                logger.log(Level.SEVERE, "Error occured sending email message");

                e.printStackTrace();
            }
        }
        else {
            logger.info("No transaction with email dispatch status of 0");
        }


    }
}
