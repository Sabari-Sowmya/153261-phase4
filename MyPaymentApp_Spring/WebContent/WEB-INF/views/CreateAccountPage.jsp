<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
</head>

<body>
<h1>Create Account</h1>
	<form:form action="create" method="post" modelAttribute="customer">
	<table>
			<tr>
				<form>
					Name:<br> <input type="text" name="name"><br>

					Mobile:<br> <input type="text" name="mobileNo"><br>

					Balance:<br> <input type="text" name="wallet.balance"><br>
				</form>
			</tr>


		</table>

		<button>Submit</button>



	</form:form>

</body>
</html>