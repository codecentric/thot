<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>

<%@ include file="header.jsp"%>
<body>
<%@ include file="menu.jsp"%>

<div class="container-fluid">

	<!--/span-->
	<div class="well well-small">
	<h2><spring:message code="map" text="map"/></h2> 
	<p>
	</div>
<br style="clear: both;"/>
<div class="row-fluid">

    <div class="span10">
      <div class="content-heading">
      <img src="<%= request.getContextPath() %>/assets/img/floor2.gif"/>
      </div>
    <div class="span10">
      <div class="content-heading">
      <img src="<%= request.getContextPath() %>/assets/img/floor3.gif"/>
      </div>
</div>

</div></div>

<%@ include file="footer.html"%>
