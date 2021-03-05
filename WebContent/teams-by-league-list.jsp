<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sports Leagues</title>
</head>
<body>
	<table style="width=100em" border="1">
		<tr>
			<th style="width=30%">Sports League</th>
			<th style="width=30%">League Name</th>
			<th style="width=30%">Hall of Fame Location</th>
		</tr>
		<c:forEach items="${requestScope.leagues}" var="league" >
			<tr>
				<td>${league.sport}</td>
				<td>${league.leagueName}</td>
				<td>${league.hallOfFame}</td>
			</tr>
			<c:forEach var="team" items="${league.listOfTeams}" >
				<tr>
					<td></td>
					<td>${team.city}</td>
					<td>${team.name}</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</table>
	<br/>
   <a href="index.html">Main Menu</a>
</body>
</html>