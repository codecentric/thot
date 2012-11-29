<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body onload="JavaScript:initTab();">
	<%@ include file="menu.jsp"%>


	<div class="container-fluid">
		<!--/span-->
		<div class="well well-small">
			<h1>
				<spring:message code="sessions" text="sessions" />
			</h1>
			<br />
			<p>For more details on content, please click the description
				inside the cells</p>
		</div>

		<br style="clear: both;" />


		<div class="row-fluid">
			<table class="table table-striped">
				<%@ include file="schedule_tableheader.html"%>
				<tbody>
					<c:forEach items="${allStaticSessions}" var="session">
                        <c:url value="comments" var="url" scope="page">
                            <c:param name="sessionId" value="${session.getId()}" />
                        </c:url>
						<tr class="sessions" data-link="${url}">
							<td>${session.getDate()}</td>
							<td>${session.getStart()}</td>
							<td>${session.getEnd()}</td>
							<td>
                                ${session.getTitle()}<a href='${url}'>  </a>
							</td>
							<td>${session.getAuthor()}</td>
							<td>${session.getLocation()}</td>
							<td></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

    <script type="text/JavaScript">
    <!--
        function initTab() {
            $('#daysTab a:last').tab('show');
        }
    //   -->
    </script>
    <%@ include file="footer.html"%>