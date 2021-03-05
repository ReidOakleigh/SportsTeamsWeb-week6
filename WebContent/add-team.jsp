<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addTeamServlet" method="post">
		City: <input type="text" name="city"> <br/>
		Name: <input type="text" name="name"> <br/>
	    Available Leagues:<br /> 
	    	<select name="sport" size="6">
			<c:forEach items="${requestScope.allLeagues}" var="league">
				<option value="${league.sport}">${league.sport}</option>
			</c:forEach>
		</select> <br /> 
		<input type="submit" value="Add Team">
	</form>
	<br/>
	<a href="index.html">Main Menu</a>
</body>
</html>