<%@page import="studentServletWithJsp.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details</title>
</head>
<body>
<% String name = (String)request.getParameter("name"); %>
 <%if(name!= null){ %>
      <h1><%="Changed by "+name %></h1>
      <%}else{%>
      <%} %>
<% List<Student> li = (List)request.getAttribute("list"); %>
<table border="2px">
	<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Address</th>
	<th>Email</th>
	<th>Password</th>
	<th>Course</th>
	<th>Fees</th>
	<th>PhoneNo</th>
	</tr>
<%for (Student stu: li){ %>
	<tr>
	<td><%=stu.getId() %></td>
	<td><%=stu.getName() %></td>
	<td><%=stu.getAddress() %></td>
	<td><%=stu.getEmail() %></td>
	<td><%=stu.getPassword() %></td>
	<td><%=stu.getCourse() %></td>
	<td><%=stu.getFees() %></td>
	<td><%=stu.getPhone() %></td>
	<td><a href="delete?id=<%=stu.getId()%>">Delete</a></td>
	<td><a href="update?id=<%=stu.getId()%>">Update</a></td>
	</tr>
<%} %>
</table>
</body>
</html>