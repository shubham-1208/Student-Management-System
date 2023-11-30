<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>    
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sign Up</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  </head>
  <body>
      
      <%String message = (String)request.getAttribute("message"); %>
      
      <%if(message!= null){ %>
      <h1><%=message %></h1>
      <%}else{%>
      <h1><%="Welcome to Student Signup Application" %></h1>
      <%} %>
      
      <form class="row g-3" action="signup" method="post">
        <div class="col-md-6">
            <label for="inputEmail4" class="form-label">Email</label>
            <input type="email" name="email" class="form-control" id="inputEmail4">
        </div>
        <div class="col-md-6">
          <label for="inputPassword4" class="form-label">Password</label>
          <input type="password" name="password" class="form-control" id="inputPassword4">
        </div>
        <div class="col-6">
          <label for="inputAddress" class="form-label">Address</label>
          <input type="text" name="address" class="form-control" id="inputAddress">
        </div>
        <div class="col-md-6">
          <label for="inputCity" class="form-label">Name</label>
          <input type="text" name="name" class="form-control" id="inputName">
        </div>
        <div class="col-md-6">
            <label for="inputZip" class="form-label">Phone</label>
            <input type="text" name="phone" class="form-control" id="inputPhone">
        </div>
        <div class="col-md-6">
            <label for="inputZip" class="form-label">Choose a course name:</label>
            <br>
			Development: <input type="radio" name="course" value="development">
        	Testing: <input type="radio" name="course" value="testing">   
			    
        </div>
        <div class="col-12">
          <button type="submit" value="SIGNUP" class="btn btn-primary">Sign up</button>
        </div>
    </form>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</body>
</html>