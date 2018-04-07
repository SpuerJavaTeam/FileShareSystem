
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>FileShareSystem</title>
    <script type="application/javascript">
        function reloadCode() {
            var time = new Date().getTime();
            document.getElementById("Code").src = "<%=request.getContextPath()%>/CheckCode/CheckCode" + time;
        }
    </script>
    <style type="text/css">
        <!--<%@ include file="/static/css/LoginPage.css"%>-->
    </style>
</head>
<body>
<div class="container">
    <div class="logo">
        <div class="logo-block-top">
        </div>
        <div class="logo-block-bottom">
        </div>
    </div>
    <h4 class="login-header">用户登录</h4>
    <div class="content">
        <form action="/login/valibate.action" method="post" class="form-group">
            <input type="text" name="username" placeholder="输入你的用户名" required class="form-input">
            <input type="password" name="password" placeholder="输入密码" required class="form-input">
            <label class="radio-label">
                <input class="radio" type="radio" name="type" value="1" required checked >
                <span class="radioInput"></span>一般用户
            </label>
            <label class="radio-label">
                <input class="radio" type="radio" name="type" value="0" >
                <span class="radioInput"></span>管理员
            </label>
            </br>
            <div align="center"><input type="submit" value="登录" class="submit-button" /></div>
        </form>
        <div class="option">
        <div class="option-left"><a href="">忘记密码</a></div>
        <div class="option-right">
            <label class="form-label"><a href="#"> 现在注册></a></label>
        </div>
    </div>
    </div>

</div>

</body>
</html>
