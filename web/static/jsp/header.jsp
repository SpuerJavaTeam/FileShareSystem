<%--
  Created by IntelliJ IDEA.
  User: Nikoace
  Date: 2018/5/13
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-md navbar-dark bg-gradient">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">
            <i class="fa d-inline fa-lg fa-cloud"></i>
            <b>&nbsp;文件共享系统</b>
        </a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse text-center justify-content-end" id="navbar2SupportedContent">
            <% if (session.getAttribute ( "user" )!=null){%>
            <a class="btn navbar-btn ml-2 btn-light text-success" href="/user/index.jsp"><%=session.getAttribute("username")%></a>
            <a class="btn navbar-btn ml-2 btn-light text-success" href="/index.jsp">&nbsp;退出登录</a>
            <%}else{%>
            <a class="btn navbar-btn ml-2 btn-light text-success" href="login.jsp">&nbsp;登录</a>
            <a class="btn navbar-btn ml-2 btn-light text-success" href="register.jsp">&nbsp;注册</a>
            <%}%>
        </div>
    </div>
</nav>
