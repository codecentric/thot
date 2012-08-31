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
	<h1><spring:message code="marketplace" text="marketplace"/></h1>
	</div>
	
	<div style="float: right;">
			<a class="btn btn-primary" href="<%= request.getContextPath() %>/editSession">Add OpenSpace</a>
	</div>

	<br style="clear: both;"/>


	<div class="row-fluid">
		<div class="tabbable">
			<ul class="nav nav-tabs">
				<li><a href="#1" data-toggle="tab">Wed</a></li>
				<li><a href="#2" data-toggle="tab">Thu</a></li>
				<li class="active"><a href="#3" data-toggle="tab">Fri</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane" id="1">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Location</th>
								<c:forEach items="${wedTimeslots}" var="timeslot">
									<th>${timeslot.toString()}</th>
								</c:forEach>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${sessionsDay1}" var="entry">
							<tr>
								<td>${entry.key}</td>
								<c:forEach items="${wedTimeslots}" var="timeslot">
								<c:set var="session" value="${entry.value.get(timeslot.getStart())}"></c:set>
								<c:choose>
								<c:when test="${session != null}">
								<td><a href='comments?sessionId=${session.id}'>${session.title}</a></td>
								</c:when>
								<c:otherwise>
									<td><i>Available slot</i></td>
								</c:otherwise>
								</c:choose>
								</c:forEach>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="tab-pane" id="2">
					<c:choose>
					<c:when test="${sessionsDay2.size()==0}">
						No sessions defined for this day
					</c:when>
					<c:otherwise>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Location</th>
								<c:forEach items="${thuTimeslots}" var="timeslot">
									<th>${timeslot}</th>
								</c:forEach>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${sessionsDay2}" var="entry">
							<tr>
								<td>${entry.key}</td>
								<c:forEach items="${thuTimeslots}" var="timeslot">
								<c:set var="session" value="${entry.value.get(timeslot.getStart())}"></c:set>
								<c:choose>
								<c:when test="${session != null}">
								<td><a href='comments?sessionId=${session.id}'>${session.title}</a></td>
								</c:when>
								<c:otherwise>
									<td><i>Available slot</i></td>
								</c:otherwise>
								</c:choose>
								</c:forEach>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					</c:otherwise>
					</c:choose>
				</div>
				<div class="tab-pane active" id="3">
					<c:choose>
					<c:when test="${sessionsDay3.size()==0}">
						No sessions defined for this day
					</c:when>
					<c:otherwise>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Location</th>
								<c:forEach items="${friTimeslots}" var="timeslot">
									<th>${timeslot}</th>
								</c:forEach>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${sessionsDay3}" var="entry">
							<tr>
								<td>${entry.key}</td>
								<c:forEach items="${friTimeslots}" var="timeslot">
								<c:set var="session" value="${entry.value.get(timeslot.getStart())}"></c:set>
								<c:choose>
								<c:when test="${session != null}">
								<td><a href='comments?sessionId=${session.id}'>${session.title}</a></td>
								</c:when>
								<c:otherwise>
									<td><i>Available slot</i></td>
								</c:otherwise>
								</c:choose>
								</c:forEach>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.html"%>
