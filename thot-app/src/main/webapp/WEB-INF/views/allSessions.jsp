<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>

<!--
<html>
<head>
<title>Thot - All Sessions</title>
<link rel="stylesheet" type="text/css" href="assets/bootstrap.css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
-->

<table>
<thead>  
	<tr>
		<th>Date</th>
		<th>Start</th>
		<th>End</th>
		<th>Title</th>
		<th>Speaker</th>
		<th>Description</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${sessions}" var="session">
	<tr>
		<td>${session.date}</td>
		<td>${session.startTime}</td>
		<td>${session.endTime}</td>
		<td>${session.title}</td>
		<td>${session.speaker}</td>
		<td>${session.description}</td>
	</tr>
</c:forEach>
</tbody>
</table>

<%@ include file="footer.html"%>
