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
										<th>Date</th>
										<th>Start</th>
										<th>End</th>
										<th>Title</th>
										<th>Speaker</th>
										<th>Description</th>
									</tr>
								</thead>
								<tbody>
<% 
	for(Session s : sessions) {
%>
									<tr>
										<td><%=s.getDate()%></td>
										<td><%=s.getStart()%></td>
										<td><%=s.getEnd()%></td>
										<td><%=s.getTitle()%></td>
										<td><%=s.getAuthor()%></td>
										<td><%=s.getDescription()%></td>
<!-- 
										<td><a href="session.html">Validate Your Influence</a></td>
										<td>Ivana Gancheva</td>
 -->										
									</tr>
<%
	} // end iterate over sessions
%>									
								</tbody>
							</table>
						</div>
						<div class="tab-pane" id="2">
							<p>You are watching Day 2.</p>
						</div>
						<div class="tab-pane" id="3">
							<p>You are watching Day 3.</p>
						</div>
					</div>

				</div>
				<!--/row-->

				<hr>

			</div>
			<!--/.fluid-container-->
			</div>

			<%@ include file="footer.html"%>