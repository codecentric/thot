<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>


<div class="container-fluid">

<div class="container-fluid">

	<!--/span-->
	<div class="well well-small">
	<h1>All Open Spaces</h1>
	</div>
	
	<div style="float: right;">
			<a class="btn btn-primary" href="<%= request.getContextPath() %>/addSession">Add OpenSpace</a>
	</div>

	<br style="clear: both;"/>


	<div class="row-fluid">
		<div class="tabbable">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#1" data-toggle="tab">Day 1</a></li>
				<li class=""><a href="#2" data-toggle="tab">Day 2</a></li>
				<li class=""><a href="#3" data-toggle="tab">Day 3</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="1">
					<p>You are watching Day 1, August 29th.</p>
					<table class="table table-striped">
						<%@ include file="openspace_tableheader.html"%>
						<tbody>
						<c:forEach items="${sessionsDay1}" var="session">
							<tr>
								<td>${session.date}</td>
								<td>${session.start}</td>
								<td>${session.location}</td>
								<td>${session.title}</td>
								<td>${session.author}</td>
								<td>${session.description}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
								<div class="tab-pane" id="2">
					<p>You are watching Day 2, August 30th.</p>
					<table class="table table-striped">
						<%@ include file="openspace_tableheader.html"%>
						<tbody>
						<c:forEach items="${sessionsDay2}" var="session">
							<tr>
								<td>${session.date}</td>
								<td>${session.start}</td>
								<td>${session.location}</td>
								<td>${session.title}</td>
								<td>${session.author}</td>
								<td>${session.description}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
								<div class="tab-pane" id="3">
					<p>You are watching Day 3, August 31th.</p>
					<table class="table table-striped">
						<%@ include file="openspace_tableheader.html"%>
						<tbody>
						<c:forEach items="${sessionsDay3}" var="session">
							<tr>
								<td>${session.date}</td>
								<td>${session.start}</td>
								<td>${session.location}</td>
								<td>${session.title}</td>
								<td>${session.author}</td>
								<td>${session.description}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
</div>
<%@ include file="footer.html"%>
