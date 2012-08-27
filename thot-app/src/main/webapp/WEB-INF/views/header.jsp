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
				</a> <a class="brand" href="#">Agile Lean Europe 2012</a>
				
				<div class="nav-collapse">
					<ul class="nav">
						<li><a href="allSessions">All sessions</a></li>
						<li><a href="addSession">Add a new session</a></li>
						<!--
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">More <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li class="divider"></li>
								<li class="nav-header">Nav header</li>
								<li><a href="#">Separated link</a></li>
							</ul></li>
						-->
					</ul>
				</div>
			</div>
		</div>
	</div>