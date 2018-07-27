package com.cg.payment.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.payment.beans.Customer;

public interface DAOServices extends JpaRepository<Customer, String> {

}
