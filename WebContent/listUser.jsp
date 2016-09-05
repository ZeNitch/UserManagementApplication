<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All users</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<th>First name</th>
				<th>Last name</th>
				<th>Date of birth</th>
				<th>Phone number</th>
				<th>Email</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
			<tr>
				<td><c:out value="${user.firstName}" /></td>
				<td><c:out value="${user.lastName}" /></td>
				<td><fmt:formatDate value="${user.dateOfBirth}" /></td>
				<td><c:out value="${user.phoneNumber}" /></td>
				<td><c:out value="${user.email}" /></td>
				
				<td><a href="UserController?action=edit&userId=<c:out value="${user.userId}"/>">Update</a></td>
                <td><a href="UserController?action=delete&userId=<c:out value="${user.userId}"/>">Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="UserController?action=insert">Add User</a></p>
	<p><a href="UserController?action=sortLastName">Sort by last name</a></p>
	<p><a href="UserController?action=sortDate">Sort by date of birth</a></p>
	
	<form action="UserController?action=search" method="POST">
   	Search: <input type=text name=par> <input type=submit value=Search>
  	</form>
	
</body>
</html>