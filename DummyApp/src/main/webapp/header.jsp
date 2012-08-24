<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>ALE OSSD 2012</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }
    </style>
    <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
  </head>

  <body>

    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="#">Agile Lean Europe 2012</a>
          <div class="btn-group pull-right">
          <%if(null == session.getAttribute("twitter")){%>
            <a class="btn btn-info btn-large" href="signin">Sign in with Twitter</a>
            <%}%>
<%if(null != session.getAttribute("twitter")){
		Twitter twitter = (Twitter) request.getSession().getAttribute("twitter");%>
            <a class="btn btn-info btn-large dropdown-toggle" data-toggle="dropdown" href="">
              <i class="icon-user"></i>@<%=twitter.getScreenName() %>
              <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
              <li class="divider"></li>
              <li><a href="./logout">Sign Out</a></li>
            </ul>
            <%}%>
          </div>
          <div class="nav-collapse">
            <ul class="nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="schedule.html">Sessions</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

