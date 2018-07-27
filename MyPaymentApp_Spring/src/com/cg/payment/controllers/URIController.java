package com.cg.payment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.payment.beans.Customer;

@Controller
public class URIController {

	@RequestMapping("/")
	public String getIndexPage() {
		System.out.println("\n In index");
		return "index";
	}

	@RequestMapping("/createaccount")
	public String getCreateAccountPage() {
		return "CreateAccountPage";
	}

	@RequestMapping("/showbalance")
	public String getShowBalancePage() {
		return "showBalancePage";
	}

	@RequestMapping("/deposit")
	public String getDepositAmountPage() {
		return "depositAmountPage";
	}

	@RequestMapping("/withdraw")
	public String getWithdrawAmountPage() {
		return "withdrawAmountPage";
	}

	@RequestMapping("/fundtransfer")
	public String getFundTransferPage() {
		return "fundTransferPage";
	}

	@ModelAttribute("customer")
	public Customer getCustomer() {
		return new Customer();
	}
}
