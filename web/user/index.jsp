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
    <title></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="../static/css/theme.css" type="text/css">
    <style type="text/css">
        #box{
            margin-top: 90px;
        }
    </style>
    <script type="text/javascript">

    </script>
</head>
<body>
<%@include file="../static/jsp/header.jsp"%>
<div class="container" id="box">
    <div class="row">
        <div class="col-lg-5" id="list">
            <ul class="list-group">
                <li class="list-group-item"><a href="#update" >上传文件</a></li>
                <li class="list-group-item"><a href="#alterfile" >修改文件信息</a></li>
                <li class="list-group-item"><a href="#alteruser" >修改用户信息</a></li>
                <li class="list-group-item"><a href="<%session.invalidate();%>">退出登录</a></li>
            </ul>
        </div>
        <div class="col-lg-7" >
            <section id="update">1</section>
            <section id="alterfile">2</section>
            <section id="alteruser">3</section>
        </div>
    </div>
</div>
<%@include file="../static/jsp/tail.jsp"%>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
