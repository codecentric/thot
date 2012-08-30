<%@ include file="header.jsp"  %>
<body>
<%@ include file="menu.jsp"%>

<div class="well well-small">
      <h1><spring:message code="versionhistory" text="versionhistory"/></h1>
</div>

<div class="container">
   <h3>Version 1.7 at Day 2 11:20</h3>
      <ul>
       <li>fixed encoding and timezone</li>
       <li>seperated comment input from comment list</li>
       <li>added important program points (lunch!)</li>
       <li>fixed navbar bug and removed modal layer</li>
       <li>added internationalization ability</li>
	  </ul>	
   <h3>Version 1.6 at Day 2 08:40</h3>
      <ul>
       <li>added the session data again</li>
       <li>change refresh interval to 20 secs</li>
	  </ul>
   <h3>Version 1.5 at Day 2 0:59</h3>
      <ul>
       <li>Added automatic reload for Market Place entries</li>
       <li>Removed Session data</li>
       <li>Removed Home Page</li>
       <li>added comments for OpenSpaces</li>
       <li>renamed "Open Spaces" to "Market Place"</li>
	  </ul>

   <h3>Version 1.4 at 17:00</h3>
      <ul>
       <li>changed order of the menu items</li>
       <li>added page to handle to during deployment</li>
	  </ul>
    <h3>Version 1.3 at 15:40</h3>
      <ul>
       <li>added all open spaces to the list</li>
       <li>updated value list for available slots on wednesday</li>
	  </ul>
    <h3>Version 1.2 at 15:10</h3>
      <ul>
       <li>additional value list for room names</li>
       <li>added value list for slots instead of start and end date</li>
	  </ul>
    <h3>Version 1.1 at 13:40</h3>
      <ul>
       <li>Different labels in OpenSpace form</li>
       <li>Options for choosing the day in OpenSpace form</li>
	  </ul>
 

  <h3>Version 1.0 at 12:40</h3>
      <ul>
       <li>Simplified menu bar for Open Space Sessions</li>
       <li>Make "Add Open Space" available from the list of Open Spaces</li>
	  </ul>
 
     <h3>Startup features</h3>
      <ul>
       <li>List of planned sessions</li>
       <li>Add additional Open Spaces</li>
       <li>List of additional Open Spaces</li>
      </ul>

	

	 <h3>Product Backlog</h3>
      <ul>
       <li>As a user I want to choose the day for a new OpenSpace so that I do not have to type in the date</li>
       <li>As a user I want to add comments to sessions I have visited.</li>
	  </ul>
	  	 
    </div> <!-- /container -->

<%@ include file="footer.html"  %>