<!--
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
-->
<html>
<head>
<title>Thot - Add Session Data</title>
<link rel="stylesheet" type="text/css" href="assets/bootstrap.css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<p>
	<form:form commandName="bookDataFormData" method="POST">
        <div class="form-label">Titel:</div><form:input id="title" path="title" />
		<form:errors class="form-error" path="title" />
		<br />
            <div class="form-label">Ausgabe:</div><form:input id="edition" path="edition" />
		<form:errors class="form-error" path="edition" />
		<br />
            <div class="form-label">ISBN:</div><form:input id="isbn" path="isbn" />
		<form:errors class="form-error" path="isbn" />
		<br />
            <div class="form-label">Autor:</div><form:input id="author" path="author" />
		<form:errors class="form-error" path="author" />
		<br />
            <div class="form-label">Jahr:</div><form:input id="year" path="year" />
		<form:errors class="form-error" path="year" />
		<br />
            <div class="form-label">Beschreibung:</div><form:input id="description" path="description" />
		<form:errors class="form-error" path="description" />

		<br />
		<input type="submit" id="addBook" value="Buch anlegen" />

	</form:form>
</p>

</body>
</html>
