<html>

<head>
  <title>Sessions</title>
  
  <link href="static/css/bootstrap.css" rel="stylesheet">
  <link href="static/css/bootstrap-responsive.css" rel="stylesheet">
  
</head>

<body>

  <#list sessions as session>
  	<p>
  		<span class="title">${session.title}</span> <br/>
  		by <span class="speaker">${session.author}</span> <br/>
  		<div class="description">
  			${session.description}
  		</p>
  	</p>
  </#list>

	<script src="assets/js/bootstrap.js"></script>
  <script src="assets/js/bootstrap.min.js"></script>
  
</body>

</html>  