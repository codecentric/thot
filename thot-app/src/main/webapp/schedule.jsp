<%@ include file="header.jsp"%>
<%@ page import="java.io.InputStream"%>
<%@ page import="java.util.List"%>
<%@ page import="org.ale.thot.domain.Session"%>
<%@ page import="org.ale.app.XlsSessionReader"%>

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
						<%@ include file="schedule_tableheader.html"%>
						<tbody>
							<% 
	for(Session s : sessions) {
		if("29. Aug.".equals(s.getDate())) {
			int i = sessions.indexOf(s);
%>
							<%@ include file="schedule_row.jsp"%>
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
							<%@ include file="schedule_tableheader.html"%>
						<tbody>
							<% 
	for(Session s : sessions) {
		if("30. Aug.".equals(s.getDate())) {	
			int i = sessions.indexOf(s);

%>
							<%@ include file="schedule_row.jsp"%>
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
						<%@ include file="schedule_tableheader.html"%>
						<tbody>
							<% 
	for(Session s : sessions) {
		if("31. Aug.".equals(s.getDate())) {
			int i = sessions.indexOf(s);
%>
							<%@ include file="schedule_row.jsp"%>
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

<% 
	for(Session s : sessions) {
		if(s.getDescription() != null) {
		  int i = sessions.indexOf(s);
%>
<div id="myModal_<%=i%>" class="modal hide" aria-hidden="true"
	aria-labelledby="myModalLabel" role="dialog" tabindex="-1">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="myModalLabel_<%=i%>"><%=s.getTitle()%></h3>
	</div>
	<div class="modal-body">
		<p><%=s.getDescription()%></p>
	</div>
</div>
<%
		}
  }
%>

<%@ include file="footer.html"%>