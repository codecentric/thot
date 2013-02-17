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
	<h1>Speakers</h1>
	</div>
<!-- 	
	<div style="float: right;">
			<a class="btn btn-primary" href="<%= request.getContextPath() %>/editSession">Add OpenSpace</a>
	</div>
-->
	<br style="clear: both;"/>


	<div class="row-fluid">
		<table class="table table-striped" style="width:auto">
			<thead>
				<tr>
					<th>Firstname</th>
					<th>Lastname</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${speakers}" var="speaker">
				<tr>
					<td>${speaker.foreName}</td>
					<td>${speaker.lastName}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>


	<%@ include file="footer.html"%>
