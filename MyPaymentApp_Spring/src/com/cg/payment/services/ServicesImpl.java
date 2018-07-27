package com.cg.payment.services;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.payment.beans.Customer;
import com.cg.payment.beans.Wallet;
import com.cg.payment.daoservices.DAOServices;

@Component(value = "service")
public class ServicesImpl implements Services {
	@Autowired
	private DAOServices dao;

	@Transactional
	@Override
	public Customer createAccount(Customer customer) {

		
		acceptDetails(customer);
		Customer c1 = dao.save(customer);

		return customer;

	}

	public Customer acceptDetails(Customer customer) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String str = customer.getMobileNo();
			if (validatephone(str)) {
				break;
			} else {
				System.out.println("Incorrect Phone Number");
				System.out.println("Enter Phone Number again ");
				customer.setMobileNo(sc.next());
			}

		}
		return customer;
	}

	private boolean validatephone(String phone) {

		String pattern = "[7-9][0-9]{9}";
		if (phone.matches(pattern)) {
			return true;
		} else {
			return false;
		}
	}

	public Customer showBalance(String mobileNo) {
		Customer customer = dao.findOne(mobileNo);
		if (customer != null)
			return customer;
		else {
			System.out.println("invalid");
		}
		return customer;
	}

	@Transactional
	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		Customer customer1 = dao.findOne(sourceMobileNo);
		Customer customer2 = dao.findOne(targetMobileNo);
		Wallet wallet1 = new Wallet(customer1.getWallet().getBalance().subtract(amount));
		Wallet wallet2 = new Wallet(customer2.getWallet().getBalance().add(amount));
		customer1.setWallet(wallet1);
		customer2.setWallet(wallet2);
		return customer1;
	}

	@Transactional
	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount) {
		Customer customer = dao.findOne(mobileNo);
		BigDecimal bal = customer.getWallet().getBalance().add(amount);
		Wallet wallet = new Wallet(bal);
		customer.setWallet(wallet);
		if (dao.save(customer) != null) {
			return customer;
		} else {
			return null;
		}

	}

	@Transactional
	@Override

	public Customer withdrawAmount(String mobileNo, BigDecimal amount) {
		Customer customer = dao.findOne(mobileNo);
		BigDecimal bal = customer.getWallet().getBalance().subtract(amount);
		Wallet wallet = new Wallet(bal);
		customer.setWallet(wallet);
		if (dao.save(customer) != null) {
			return customer;

		} else {
			return null;
		}
	}

}
