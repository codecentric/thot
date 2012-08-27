<%@ include file="header.jsp"%>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.util.List" %>
<%@ page import="org.ale.domain.Session" %>
<%@ page import="org.ale.app.XlsSessionReader" %>

<div class="container-fluid">

		<!--/span-->
			<div class="well well-small">
				<h1>Program outline</h1>
				<br />
				<p>For more details on content, please click the description
					inside the cells</p>
			</div>
<%! 	
      private String emptyIfNull(String s) {
				return s == null ? "" : s;
			}

			final XlsSessionReader sessionReader = new XlsSessionReader();
			final List<Session> sessions = sessionReader.readAllSessions();
%>			 
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
								<thead>
									<tr>
										<th>Start</th>
										<th>End</th>
										<th>Title</th>
										<th>Speaker</th>
										<th>Location</th>
										<th>Description</th>
									</tr>
								</thead>
								<tbody>
<% 
	for(Session s : sessions) {
		if("29. Aug.".equals(s.getDate())) {	
%>
									<tr>
										<td><%=emptyIfNull(s.getStart())%></td>
										<td><%=emptyIfNull(s.getEnd())%></td>
										<td><%=emptyIfNull(s.getTitle())%></td>
										<td><%=emptyIfNull(s.getAuthor())%></td>
										<td><%=emptyIfNull(s.getLocation())%></td>
										<td><%=emptyIfNull(s.getDescription())%></td>
									</tr>
<%
		  }
		} // end iterate over sessions
%>									
								</tbody>
							</table>
						</div>
						<div class="tab-pane" id="2">
							<p>You are watching Day 2, August 30th.</p>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Start</th>
										<th>End</th>
										<th>Title</th>
										<th>Speaker</th>
										<th>Location</th>
										<th>Description</th>
									</tr>
								</thead>
								<tbody>
<% 
	for(Session s : sessions) {
		if("30. Aug.".equals(s.getDate())) {	
%>
									<tr>
										<td><%=emptyIfNull(s.getStart())%></td>
										<td><%=emptyIfNull(s.getEnd())%></td>
										<td><%=emptyIfNull(s.getTitle())%></td>
										<td><%=emptyIfNull(s.getAuthor())%></td>
										<td><%=emptyIfNull(s.getLocation())%></td>
										<td><%=emptyIfNull(s.getDescription())%></td>
									</tr>
<%
		  }
		} // end iterate over sessions
%>									
								</tbody>
							</table>
						</div>
						<div class="tab-pane" id="3">
							<p>You are watching Day 3, August the 31st.</p>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Start</th>
										<th>End</th>
										<th>Title</th>
										<th>Speaker</th>
										<th>Location</th>
										<th>Description</th>
									</tr>
								</thead>
								<tbody>
<% 
	for(Session s : sessions) {
		if("31. Aug.".equals(s.getDate())) {	
%>
									<tr>
										<td><%=emptyIfNull(s.getStart())%></td>
										<td><%=emptyIfNull(s.getEnd())%></td>
										<td><%=emptyIfNull(s.getTitle())%></td>
										<td><%=emptyIfNull(s.getAuthor())%></td>
										<td><%=emptyIfNull(s.getLocation())%></td>
										<td><%=emptyIfNull(s.getDescription())%></td>
									</tr>
<%
		  }
		} // end iterate over sessions
%>									
								</tbody>
							</table>

						</div>
					</div>

				</div>
				<!--/row-->

				<hr>

			</div>
			<!--/.fluid-container-->
			</div>

			<%@ include file="footer.html"%>