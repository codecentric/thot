<%@ include file="header.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<!--
<html>
<head>
<title>Thot - Add Session Data</title>
<link rel="stylesheet" type="text/css" href="assets/bootstrap.css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
-->

<p>
	<form:form commandName="sessionDataFormData" method="POST">
	
        <div>Date:</div>
        <form:input id="date" path="date" />
		<form:errors class="form-error" path="date" />
		<br />
		
        <div>Title:</div>
        <form:input id="title" path="title" />
		<form:errors class="form-error" path="title" />
		<br />
        
        <div>Speaker:</div>
        <form:input id="speaker" path="speaker" />
		<form:errors class="form-error" path="speaker" />
		<br />
        
        <div>Description:</div>
        <form:textarea cols="30" rows="4" id="description" path="description" />
		<form:errors class="form-error" path="description" />
		<br />
        
		<div>Start:</div>
		<form:input id="start" path="start" />
		<form:errors class="form-error" path="start" />
		<br />
		
        <div>End:</div>
        <form:input id="end" path="end" />
		<form:errors class="form-error" path="end" />
		<br />
		
		<input type="submit" id="addSession" value="Add session" />

	</form:form>
</p>

<%@ include file="footer.html"%>
