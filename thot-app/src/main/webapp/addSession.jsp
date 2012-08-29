<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<!--
<html>
<head>
<title>Thot - Add Session Data</title>
<link rel="stylesheet" type="text/css" href="assets/bootstrap.css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
-->
<div class="container-fluid">

	<!--/span-->
	<div class="well well-small">
	<h1>Add Session Data</h1>
	</div>
	
	<div class="row-fluid">
	<form:form commandName="sessionDataFormData" method="POST">
	
	 	<form:radiobutton id="date" path="date" value="Wed" />&nbsp;Wed&nbsp;&nbsp;
   		<form:radiobutton id="date" path="date" value="Thu" />&nbsp;Thu&nbsp;&nbsp;
   		<form:radiobutton id="date" path="date" value="Fri" />&nbsp;Fri&nbsp;&nbsp;
		<form:errors class="form-error" path="date" />
		<br />
		
        <div>Topic:(*)</div>
        <form:input id="title" path="title" />
		<form:errors class="form-error" path="title" />
		<br />
        
        <div>Proposed by:</div>
        <form:input id="speaker" path="speaker" />
		<form:errors class="form-error" path="speaker" />
		<br />
        
        <div>Description:</div>
        <form:textarea cols="30" rows="4" id="description" path="description" />
		<form:errors class="form-error" path="description" />
		<br />
        
		<div>Slot:</div>
		<form:select id="start" path="start" />
		<form:option value="15:30" label="15:30 - 16:00"/>
		<form:option value="16:00" label="16:00 - 16:30"/>
		<form:option value="16:30" label="16:30 - 17:00"/>
		
		<form:errors class="form-error" path="start" />
		<br />
		
		<input type="submit" id="addSession" value="Add session" />

	</form:form>
</div>
</div>

<%@ include file="footer.html"%>
