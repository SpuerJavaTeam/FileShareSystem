<%@ page import="com.filesharesystem.models.User" %>
<%@ page import="org.apache.struts2.ServletActionContext" %><%--
  Created by IntelliJ IDEA.
  User: Nikoace
  Date: 2018/5/22
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        User user = (User)ServletActionContext.getRequest ().getSession ().getAttribute ( "user" );
    %>
</head>
<body>
<div class="content">
    updateuser
</div>
</body>
</html>
