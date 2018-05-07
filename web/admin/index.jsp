<%--
  Created by IntelliJ IDEA.
  User: KuoYu
  Date: 2018/4/2
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/login/sign_up.action">
    用户名:<input type="text" name="username"/>
    密码:<input type="password" name="password"/>
    email:<input type="email" name="email"/>
    <input type="submit" value="submit"/>
</form>
</body>
</html>
