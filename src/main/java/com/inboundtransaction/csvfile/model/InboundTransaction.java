package com.inboundtransaction.csvfile.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inbound_transactions")
public class InboundTransaction {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String transactionTypeDescription;
	
	private String requesterIdNumber;
	
	private String requesterCustomerName;
	
	private String requesterMobileNumber;
	
	private String bankAcountName;
	
	private String bankAcountNumber;
	
	private String bankAcountType;
	
	private String requesterSessionId;
	
	private String requesterCellNetwork;
	
	private String insurancePolicyNumberProvided;
	
	private String insurancePolicyNumber;
	
	private String  withdrawalType;
	
	private String withdrawalAmount;
	
	private String withdrawalFundType;
	
	private String deceasedIdNumber;
	
	private String channel;
	
	private String emailDispatchStatus;
	
	private String requesterTermsConditions;
	
	private String createdAt;
	
	private String updatedAt;


		public InboundTransaction() {
			super();
		}



		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getTransactionTypeDescription() {
			return transactionTypeDescription;
		}


		public void setTransactionTypeDescription(String transactionTypeDescription) {
			this.transactionTypeDescription = transactionTypeDescription;
		}


		public String getRequesterIdNumber() {
			return requesterIdNumber;
		}


		public void setRequesterIdNumber(String requesterIdNumber) {
			this.requesterIdNumber = requesterIdNumber;
		}


		public String getRequesterCustomerName() {
			return requesterCustomerName;
		}


		public void setRequesterCustomerName(String requesterCustomerName) {
			this.requesterCustomerName = requesterCustomerName;
		}


		public String getRequesterMobileNumber() {
			return requesterMobileNumber;
		}


		public void setRequesterMobileNumber(String requesterMobileNumber) {
			this.requesterMobileNumber = requesterMobileNumber;
		}


		public String getBankAcountName() {
			return bankAcountName;
		}



		public void setBankAcountName(String bankAcountName) {
			this.bankAcountName = bankAcountName;
		}



		public String getBankAcountNumber() {
			return bankAcountNumber;
		}



		public void setBankAcountNumber(String bankAcountNumber) {
			this.bankAcountNumber = bankAcountNumber;
		}



		public String getBankAcountType() {
			return bankAcountType;
		}



		public void setBankAcountType(String bankAcountType) {
			this.bankAcountType = bankAcountType;
		}



		public String getRequesterSessionId() {
			return requesterSessionId;
		}


		public void setRequesterSessionId(String requesterSessionID) {
			this.requesterSessionId = requesterSessionID;
		}


		public String getRequesterCellNetwork() {
			return requesterCellNetwork;
		}


		public void setRequesterCellNetwork(String requesterCellNetwork) {
			this.requesterCellNetwork = requesterCellNetwork;
		}


		public String getInsurancePolicyNumberProvided() {
			return insurancePolicyNumberProvided;
		}


		public void setInsurancePolicyNumberProvided(String insurancePolicyNumberProvided) {
			this.insurancePolicyNumberProvided = insurancePolicyNumberProvided;
		}


		public String getInsurancePolicyNumber() {
			return insurancePolicyNumber;
		}


		public void setInsurancePolicyNumber(String insurancePolicyNumber) {
			this.insurancePolicyNumber = insurancePolicyNumber;
		}


		public String getWithdrawalType() {
			return withdrawalType;
		}


		public void setWithdrawalType(String withdrawalType) {
			this.withdrawalType = withdrawalType;
		}


		public String getWithdrawalAmount() {
			return withdrawalAmount;
		}


		public void setWithdrawalAmount(String withdrawalAmount) {
			this.withdrawalAmount = withdrawalAmount;
		}


		public String getWithdrawalFundType() {
			return withdrawalFundType;
		}


		public void setWithdrawalFundType(String withdrawalFundType) {
			this.withdrawalFundType = withdrawalFundType;
		}


		public String getDeceasedIdNumber() {
			return deceasedIdNumber;
		}


		public void setDeceasedIdNumber(String deceasedIdNumber) {
			this.deceasedIdNumber = deceasedIdNumber;
		}


		public String getChannel() {
			return channel;
		}


		public void setChannel(String channel) {
			this.channel = channel;
		}


		public String getEmailDispatchStatus() {
			return emailDispatchStatus;
		}


		public void setEmailDispatchStatus(String emailDispatchStatus) {
			this.emailDispatchStatus = emailDispatchStatus;
		}


		public String getRequesterTermsConditions() {
			return requesterTermsConditions;
		}


		public void setRequesterTermsConditions(String requesterTermsConditions) {
			this.requesterTermsConditions = requesterTermsConditions;
		}


		public String getCreatedAt() {
			return createdAt;
		}


		public void setCreatedAt(String createdAt) {
			this.createdAt = createdAt;
		}


		public String getUpdatedAt() {
			return updatedAt;
		}


		public void setUpdatedAt(String updatedAt) {
			this.updatedAt = updatedAt;
		}



		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("InboundTransaction [id=");
			builder.append(id);
			builder.append(", transactionTypeDescription=");
			builder.append(transactionTypeDescription);
			builder.append(", requesterIdNumber=");
			builder.append(requesterIdNumber);
			builder.append(", requesterCustomerName=");
			builder.append(requesterCustomerName);
			builder.append(", requesterMobileNumber=");
			builder.append(requesterMobileNumber);
			builder.append(", bankAcountName=");
			builder.append(bankAcountName);
			builder.append(", bankAcountNumber=");
			builder.append(bankAcountNumber);
			builder.append(", bankAcountType=");
			builder.append(bankAcountType);
			builder.append(", requesterSessionID=");
			builder.append(requesterSessionId);
			builder.append(", requesterCellNetwork=");
			builder.append(requesterCellNetwork);
			builder.append(", insurancePolicyNumberProvided=");
			builder.append(insurancePolicyNumberProvided);
			builder.append(", insurancePolicyNumber=");
			builder.append(insurancePolicyNumber);
			builder.append(", withdrawalType=");
			builder.append(withdrawalType);
			builder.append(", withdrawalAmount=");
			builder.append(withdrawalAmount);
			builder.append(", withdrawalFundType=");
			builder.append(withdrawalFundType);
			builder.append(", deceasedIdNumber=");
			builder.append(deceasedIdNumber);
			builder.append(", channel=");
			builder.append(channel);
			builder.append(", emailDispatchStatus=");
			builder.append(emailDispatchStatus);
			builder.append(", requesterTermsConditions=");
			builder.append(requesterTermsConditions);
			builder.append(", createdAt=");
			builder.append(createdAt);
			builder.append(", updatedAt=");
			builder.append(updatedAt);
			builder.append("]");
			return builder.toString();
		}


		



	
	
	
	
	
	


}
