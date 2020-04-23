USE `db_inbound_transactions`;

DROP TABLE IF EXISTS `inbound_transactions`;

CREATE TABLE IF NOT EXISTS `inbound_transactions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `transaction_type_description` varchar(191)  NOT NULL,
  `requester_id_number` varchar(191)  NOT NULL,
  `requester_customer_name` varchar(191) NOT NULL,
  `requester_mobile_number` varchar(191)  NOT NULL,
  `bank_acount_name` varchar(191)  NOT NULL,
  `bank_acount_number` varchar(191) NOT NULL,
  `bank_acount_type` varchar(191) NOT NULL,
  `requester_session_id` varchar(191) NOT NULL,
  `requester_cell_network` varchar(191) NOT NULL,
  `insurance_policy_number_provided` varchar(191)  NOT NULL DEFAULT 'N/A',
  `insurance_policy_number` varchar(191) NOT NULL DEFAULT 'N/A',
  `withdrawal_type` varchar(191) NOT NULL DEFAULT 'N/A',
  `withdrawal_amount` varchar(191) NOT NULL DEFAULT 'N/A',
  `withdrawal_fund_type` varchar(191) NOT NULL DEFAULT 'N/A',
  `deceased_id_number` varchar(191) NOT NULL DEFAULT 'N/A',
  `channel` varchar(191) NOT NULL DEFAULT 'USSD',
  `email_dispatch_status` varchar(191) NOT NULL DEFAULT '0',
  `requester_terms_conditions` varchar(191) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET= latin1;



INSERT INTO `inbound_transactions` (`id`, `transaction_type_description`, `requester_id_number`, `requester_customer_name`, `requester_mobile_number`, `bank_acount_name`, `bank_acount_number`, `bank_acount_type`, `requester_session_id`, `requester_cell_network`, `insurance_policy_number_provided`, `insurance_policy_number`, `withdrawal_type`, `withdrawal_amount`, `withdrawal_fund_type`, `deceased_id_number`, `channel`, `email_dispatch_status`, `requester_terms_conditions`, `created_at`, `updated_at`) VALUES
(1, 'Full Withdrawal', '910802xxxxxx', 'Emme Bates', '060382xxxxx', 'Standard', '85215445xxx', 'Salary', '97897728978', 'Telkom', 'True', '12346565xxx', 'Full', 'N/A', 'N/A', 'N/A', 'USSD', '2', 'True', '2020-04-21 12:50:51', '2020-04-21 12:52:58'),
(2, 'Funeral Claim', '910802xxxxxx', 'Alexia Wells', '060382xxxxx', 'Ecobank', '20010158xxxx', 'Savings', '95579728972', 'Mobinil', 'N/A', 'N/A', 'N/A', 'N/A', 'N/A', '6455352xxxxx', 'USSD', '0', 'True', '2020-04-21 12:51:01', '2020-04-21 12:51:01'),
(3, 'Partial Withdrawal', '910802xxxxxx', 'Edwin J. Nesler', '06038278xxx', 'ABSA', '953625445xxx', 'Brokerage account', '178979728972', 'MTN', 'True', '12346565xxx', 'Partial', '1000', 'Evenly', 'N/A', 'USSD', '0', 'True', '2020-04-21 12:51:57', '2020-04-21 12:51:57'),
(4, 'Full Withdrawal', '910802xxxxxx', 'Emme Bates', '060382xxxxx', 'Standard', '85215445xxx', 'Salary', '97897728978', 'Telkom', 'True', '12346565xxx', 'Full', 'N/A', 'N/A', 'N/A', 'USSD', '0', 'True', '2020-04-21 12:52:09', '2020-04-21 12:52:09'),
(5, 'Funeral Claim', '910802xxxxxx', 'Alexia Wells', '060382xxxxx', 'Ecobank', '20010158xxxx', 'Savings', '95579728972', 'Mobinil', 'N/A', 'N/A', 'N/A', 'N/A', 'N/A', '6455352xxxxx', 'USSD', '0', 'True', '2020-04-21 12:52:20', '2020-04-21 12:52:20');

