<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fund Transfer</title>
</head>
<body>
<h1>Fund Transfer</h1>
	<form:form action="fundTransfer" method="post">
		<table>
			<tr>
				<form>


					SourceMobile:<br> <input type="text" name="targetMobileNo"><br>
					TargetMobile:<br> <input type="text" name="sourceMobileNo"><br>
					Amount:<br> <input type="text" name="amount"><br>
				</form>
			</tr>


		</table>

		<button>Submit</button>



	</form:form>
</body>
</html>