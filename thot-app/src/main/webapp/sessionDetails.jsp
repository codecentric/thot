<%@ page import="org.ale.thot.domain.Session"%>
<%@ page import="org.ale.app.XlsSessionReader"%>

<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

<div class="container-fluid">

	<!--/span-->
	<div class="well well-small">
		<h1>Session Details</h1>
	</div>
<% 
	final String sessionId = request.getParameter("sessionId"); 
	final XlsSessionReader sessionReader = XlsSessionReader.getInstance();
	final Session ses = sessionReader.getSession(sessionId);
%>	

	<div class="row-fluid">
		<h3><%=ses.getTitle()%></h3>
		<p><%=ses.getDescription()%></p>
	</div>
	
</div>

<div class="container">
	<p class="pull-right"><a href="javascript:history.back();" class="btn">back</a></p>
</div>

<%@ include file="footer.html"%>