<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css"
    href="css/base/jquery-ui.min.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<title>Add new user</title>
</head>
<body>
 	<script>
        $(function() {
            $('input[name=dateOfBirth]').datepicker();
        });
    </script>
	<form method="POST" action='UserController?action=create' name="frmAddUser">
		User ID : <input type="text" readonly="readonly" name="userId"
            value="<c:out value="${user.userId}" />" /> <br />  
        First Name : <input
            type="text" name="firstName"
            value="<c:out value="${user.firstName}" />" /> <br /> 
        Last Name : <input
            type="text" name="lastName"
            value="<c:out value="${user.lastName}" />" /> <br /> 
        Date of Birth : <input
            type="text" name="dateOfBirth"
            value="${user.dateOfBirth}" />  <br /> 
        Phone number : <input
            type="text" name="phoneNumber"
            value="<c:out value="${user.phoneNumber}" />" /> <br />
        Email : <input type="text" name="email"
            value="<c:out value="${user.email}" />" /> <br /> <input
            type="submit" value="Submit" />
    </form>
</body>
</html>