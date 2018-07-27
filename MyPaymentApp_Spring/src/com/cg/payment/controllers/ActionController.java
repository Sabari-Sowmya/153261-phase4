package com.cg.payment.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.payment.beans.Customer;
import com.cg.payment.services.Services;

@Controller
public class ActionController {
	@Autowired(required = true)
	private Services service;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createAccount(@ModelAttribute("customer") Customer customer) {
		try {

			customer = service.createAccount(customer);

			ModelAndView modelAndView = new ModelAndView("CreateAccountSuccess", "customer", customer);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("errorPage");
	}

	@RequestMapping(value = "/showBalance")
	public ModelAndView showBalance(@RequestParam("mobileNo") String mobileNo) {
		try {
			Customer customer = service.showBalance(mobileNo);
			ModelAndView modelAndView = new ModelAndView("showBalanceSuccess", "customer", customer);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("error");
	}

	@RequestMapping(value = "/depositAmount")
	public ModelAndView depositAmount(@RequestParam("mobileNo") String mobileNo,
			@RequestParam("amount") BigDecimal amount) {
		try {
			Customer customer = service.depositAmount(mobileNo, amount);

			ModelAndView modelAndView = new ModelAndView("depositAmountSuccess", "customer", customer);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("error");
	}

	@RequestMapping(value = "/withdrawAmount")
	public ModelAndView withdrawAmount(@RequestParam("mobileNo") String mobileNo,
			@RequestParam("amount") BigDecimal amount) {
		try {
			Customer customer = service.withdrawAmount(mobileNo, amount);
			ModelAndView modelAndView = new ModelAndView("withdrawAmountSuccess", "customer", customer);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("error");
	}

	@RequestMapping(value = "/fundTransfer")
	public ModelAndView fundTransfer(@RequestParam("sourceMobileNo") String sourceMobileNo,
			@RequestParam("targetMobileNo") String targetMobileNo, @RequestParam("amount") BigDecimal amount) {
		try {
			Customer customer = service.fundTransfer(sourceMobileNo, targetMobileNo, amount);
			ModelAndView modelAndView = new ModelAndView("fundTransferSuccess", "customer", customer);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("error");
	}
}
