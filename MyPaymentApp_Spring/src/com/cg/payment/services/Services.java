package com.cg.payment.services;

import java.math.BigDecimal;



import com.cg.payment.beans.Customer;

public interface Services {

	

	

	public Customer depositAmount(String mobileNo, BigDecimal amount);

	public Customer withdrawAmount(String mobileNo, BigDecimal amount);

	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount);
	public Customer showBalance(String mobileNo) ;
	

	public Customer createAccount(Customer customer);

	//Customer createAccount(String name, String mobileNo, BigDecimal amount);

}
