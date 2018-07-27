<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Amount Deposited </title>
</head>
<body>
<h1>Amount Deposited </h1>
	<div>
		 ${customer.name}<br> Mobile Number:<b>
			${customer.mobileNo}</b><br> Balance:<b>
			${customer.wallet.balance}</b><br>
</body>
</html>