	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="<%= request.getContextPath() %>">Agile Lean Europe 2012</a>
								
				<div class="nav-collapse">
					<ul class="nav">
						<li><a href="<%= request.getContextPath() %>/allSessions">
						<spring:message code="marketplace" text="marketplace"/></a></li>
						<li><a href="schedule.jsp"><spring:message code="sessions" text="sessions"/></a></li>
						<li><a href="features.jsp"><spring:message code="versionhistory" text="versionhistory"/></a></li>
						<li><a href="map.jsp"><spring:message code="map" text="map"/></a>
<!--                    
						<li class="active"><a href="home.jsp">Home</a></li>
						
-->
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>