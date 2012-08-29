<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

<div class="container-fluid">

	<!--/span-->
	<div class="well well-small">
	<h2>Comments for session:</h2>
	<p>
    <h3>${sessionTitle}</h3> 
	<p>
	</div>
	
	<br style="clear: both;"/>

	<div class="row-fluid">
	<!-- commit form -->
	<form:form commandName="commentFormData" method="POST">
        <div>Name:(*)</div>
        <form:input id="author" path="author" />
		<form:errors class="form-error" path="author" />
		<br />
        
        <div>Comment:</div>
        <form:textarea id="text" path="text" />
		<form:errors class="form-error" path="text" />
        
		<br />
		
		<input type="submit" id="addComment" value="Add comment" />

	</form:form>
<table class="table table-striped">
<thead>  
	<tr>  
		<th>Name</th>
		<th>Comment</th>
		 <th>Date</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${comments}" var="comment">
	<tr>
		<td>${comment.author}</td>
		<td>${comment.text}</td>
		<td><fmt:formatDate value="${comment.date}" type="both"  dateStyle="short" timeStyle="short" /></td>
	</tr>
</c:forEach>
</tbody>
</table>
</div></div>

<script type="text/JavaScript">
<!--
function timedRefresh(timeoutPeriod) {
	setTimeout("location.reload(true);",timeoutPeriod);
}
//   -->
</script>

<%@ include file="footer.html"%>
