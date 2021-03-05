<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add League</title>
</head>
<body>
	<form action="addLeagueServlet" method="post">
		League: <input type="text" name="leagueId">
		Name: <input type="text" name="leagueName">
		Hall of Fame: <input type="text" name="hallOfFame">
		<input type="submit" value="Add League">
	</form>
	<br/>
	<a href="index.html">Main Menu</a>
</body>
</html>