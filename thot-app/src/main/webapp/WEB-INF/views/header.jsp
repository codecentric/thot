<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>ALE OSSD 2012</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link href="<%= request.getContextPath() %>/assets/css/bootstrap.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}
</style>
<link href="<%= request.getContextPath() %>/assets/css/bootstrap-responsive.css" rel="stylesheet">
</head>

<body>

	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="<%= request.getContextPath() %>">Agile Lean Europe 2012</a>
				
				<div class="nav-collapse">
					<ul class="nav">
						<li class="active"><a href="home.jsp">Home</a></li>
						<li><a href="schedule.jsp">Sessions</a></li>
						<li><a href="features.jsp">Features</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">More <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li class="nav-header">Open Spaces</li>
								<li><a href="<%= request.getContextPath() %>/addSession">Add OpenSpace</a></li>
								<li><a href="<%= request.getContextPath() %>/allSessions">List all OpenSpaces</a></li>
								<li class="divider"></li>
							</ul></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>