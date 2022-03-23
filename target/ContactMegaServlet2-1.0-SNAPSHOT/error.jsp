<%--
  Created by IntelliJ IDEA.
  User: ahrrass
  Date: 23/03/2022
  Time: 02:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Sorry an exception occured!</h3>

<h2 style="color: red;">
    Exception is: <%= exception.getMessage() %>

</h2>
<a href="admin.do">Back</a>

</body>
</html>
