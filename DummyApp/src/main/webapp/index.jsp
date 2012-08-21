<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="twitter4j.Twitter" %>
<html>
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
    <title>Sign in with Twitter example</title>
</head>
<body>
<%if(null == session.getAttribute("twitter")){%>
    <a href="signin"><img src="assets/img/sign-in-with-twitter.png" alt="Sign in"></a>
<%}%>
<%if(null != session.getAttribute("twitter")){
		Twitter twitter = (Twitter) request.getSession().getAttribute("twitter");%>
    <h1>Welcome <%=twitter.getScreenName() %> (<%=twitter.getId()%>)</h1>

    <form action="./post" method="post">
        <textarea cols="80" rows="2" name="text"></textarea>
        <input type="submit" name="post" value="update"/>
    </form>
    <a href="./logout">logout</a>
<%}%>
</body>
</html>