package com.inboundtransaction.csvfile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inboundtransaction.csvfile.model.InboundTransaction;


@Repository
public interface InboundTransactionRepo extends JpaRepository<InboundTransaction, Integer> {
	
	@Query("SELECT u FROM InboundTransaction u WHERE u.emailDispatchStatus = :status")
	public List<InboundTransaction> findByEmailDispatchStatus(@Param("status") String status);
	
	
	
}
