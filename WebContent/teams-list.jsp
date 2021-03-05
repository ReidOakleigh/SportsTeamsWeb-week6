<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sports Teams</title>
</head>
<body>
  <form method="post" action="navigationServlet">
	<table style="width=100em" border="1">
		<tr>
			<th style="width=10%">Select</th>
			<th style="width=30%">City Name</th>
			<th style="width=30%">Team Name</th>
			<th style="width=30%">Sports League</th>
		</tr>
		<c:forEach items="${requestScope.allTeams}" var="currentteam" >
			<tr>
				<td><input type="radio" name="id" value="${currentteam.id}"></td>
				<td>${currentteam.city}</td>
				<td>${currentteam.name}</td>
				<td>${currentteam.league.sport}</td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value="edit"   name="doThisToTeam">
	<input type="submit" value="delete" name="doThisToTeam">
  </form>
  <br/>
  <a href="index.html">Main Menu</a>
</body>
</html>