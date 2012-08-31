<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

<div class="container-fluid">

	<!--/span-->
	<div class="well well-small">
	<h1>Add Session Data</h1>
	</div>
	
	<div class="row-fluid">
	<form:form commandName="sessionDataFormData" method="POST">
	
    <div>Topic:(*)</div>
        <form:input maxlength="255" id="title" path="title" />
		<form:errors class="form-error" path="title" />
		
	 	<div>Day</div>
	 	<form:radiobutton id="date" path="date" value="Wed" class="date" />&nbsp;Wed&nbsp;&nbsp;
   		<form:radiobutton id="date" path="date" value="Thu" class="date" checked="checked"/>&nbsp;Thu&nbsp;&nbsp;
   		<form:radiobutton id="date" path="date" value="Fri" class="date" />&nbsp;Fri&nbsp;&nbsp;
		<form:errors class="form-error" path="date" />
		<br />
		
		<div>Slot:</div>
		<form:select id="start" path="start" >
		<c:forEach items="${timeslots}" var="timeslot">
		<form:option value="${timeslot.getStart()}" label="${timeslot.toString()}"/>
		</c:forEach>
		</form:select>
		<form:errors class="form-error" path="start" />
		
		<div>Location:</div>
		<form:select id="location" path="location" >
		<form:option value="Red" label="Red"/>
		<form:option value="Orange" label="Orange"/>
		<form:option value="Brown" label="Brown"/>
		<form:option value="Green" label="Green"/>
		<form:option value="Blue" label="Blue"/>
		<form:option value="Purple" label="Purple"/>
		<form:option value="Grey" label="Grey"/>
		</form:select>
		<form:errors class="form-error" path="start" />

		<br />
        
        <div>Proposed by:</div>
        <form:input maxlength="255" id="speaker" path="speaker" />
		<form:errors class="form-error" path="speaker" />
		<br />
        
        <div>Description:</div>
        <form:textarea  maxlength="255" cols="30" rows="4" id="description" path="description" />
		<form:errors class="form-error" path="description" />
		<br />
        
		<br />
		
		<input type="submit" id="addSession" value="Add session" />

	</form:form>
</div>
</div>


<%@ include file="footer.html"%>

<script type="text/JavaScript">
	$(document).ready(function() {
		$(".date").change(function(){
			$.getJSON('./addSession/timeslotsPerDay?day=' + $(this).val(), function(timeslots) {
				var items = [];

				$.each(timeslots, function(key, value) {
				    items.push('<option value="' + key + '">' + value + '</option>');
				  });
				
				$("#start").empty();

				$("#start").append(items.join(''));
			});
		});
	});
</script>
