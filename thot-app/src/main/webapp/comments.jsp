<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body onload="JavaScript:timedRefresh(20000);">
	<%@ include file="menu.jsp"%>

	<div class="container-fluid">

		<div style="float: right;">
			<c:if test="${sessionEditable}">
				<a class="btn btn-primary"
					href="<%= request.getContextPath() %>/editSession?sessionId=${sessionId}">Edit
					session data</a>
			</c:if>
		</div>

		<!--/span-->
		<div class="well well-small">

			<!-- 
	<h4>For session at location: ${sessionLocationAndTimeSlot}</h4>
-->
			<h2>${sessionTitle}</h2>
			<h4>Description</h4>
			<p>${sessionDescription}</p>
			<h4>Proposed by</h4>
			<p>${sessionSpeaker}</p>
			<h4>Location</h4>
			<p>${location}</p>
			<h4>Start time</h4>
			<p>${timeslot }</p>
		</div>

		<br style="clear: both;" />

		<div class="row-fluid">
			<div style="float: right;">
				<a class="btn btn-primary"
					href="<%= request.getContextPath() %>/addComment?sessionId=<%= request.getParameter("sessionId")%>&title=${sessionTitle}">Add
					Comment</a>
			</div>

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
							<td>${comment.processedAuthor}</td>
							<td>${comment.text}</td>
							<td><fmt:formatDate value="${comment.date}" type="both"
									dateStyle="short" timeStyle="short" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	<script type="text/JavaScript">
	<!--
		function timedRefresh(timeoutPeriod) {
			setTimeout("location.reload(true);", timeoutPeriod);
		}
	//   -->
	</script>

	<%@ include file="footer.html"%>