<%--
  Created by IntelliJ IDEA.
  User: KuoYu
  Date: 2018/4/2
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
    User userIndex = (User) ServletActionContext.getRequest ().getSession ().getAttribute ( "user" );
    if (userIndex != null){
        session.setAttribute ( "user",userIndex );
    }
    else {
%>
<script>
    alert("noob");
</script>
<%}%>


<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
          type="text/css">
    <link rel="stylesheet" href="../static/css/theme.css" type="text/css">
    <style type="text/css">
        #box {
            margin-top: 90px;
        }
    </style>
</head>
<body>
<%@include file="../static/jsp/header.jsp" %>
<div class="container" id="box">
    <div class="row">
        <div class="col-lg-5" id="list">
            <ul class="list-group">
                <li class="list-group-item"><a onclick="showAtRight('up.jsp')">上传文件</a></li>
                <li class="list-group-item"><a onclick="showAtRight('updatefile.jsp')">修改文件信息</a></li>
                <li class="list-group-item"><a onclick="showAtRight('updateuser.jsp')">修改用户信息</a></li>
                <li class="list-group-item"><a href="<%session.invalidate();%>">退出登录</a></li>
            </ul>
        </div>

        <div class="col-lg-7">
            <div id="content">
                <h4>
                    <p>欢迎来到用户管理模块</p>
                </h4>
            </div>
        </div>

    </div>
</div>
<%@include file="../static/jsp/tail.jsp" %>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

<script type="text/javascript">

    $(document).ready(function () {
        $('ul > li').click(function (e) {
            $('ul > li').removeClass('active');
            $(this).addClass('active');
        });
    });

    function executeScript(html) {

        var reg = /<script[^>]*>([^\x00]+)$/i;
        var htmlBlock = html.split("<\/script>");
        for (var i in htmlBlock) {
            var blocks;//匹配正则表达式的内容数组，blocks[1]就是真正的一段脚本内容，因为前面reg定义我们用了括号进行了捕获分组
            if (blocks = htmlBlock[i].match(reg)) {
                //清除可能存在的注释标记，对于注释结尾-->可以忽略处理，eval一样能正常工作
                var code = blocks[1].replace(/<!--/, '');
                try {
                    eval(code) //执行脚本
                }
                catch (e) {
                }
            }
        }
    }


    function showAtRight(url) {
        var xmlHttp;

        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlHttp = new XMLHttpRequest();    //创建 XMLHttpRequest对象
        }

        xmlHttp.onreadystatechange = function () {
            //onreadystatechange — 当readystate变化时调用后面的方法

            if (4 === xmlHttp.readyState) {
                //xmlHttp.readyState == 4    ——    finished downloading response

                if (xmlHttp.status === 200) {
                    //xmlHttp.status == 200        ——    服务器反馈正常

                    document.getElementById("content").innerHTML = xmlHttp.responseText;    //重设页面中id="content"的div里的内容
                    executeScript(xmlHttp.responseText);    //执行从服务器返回的页面内容里包含的JavaScript函数
                }
                //错误状态处理
                else if (xmlHttp.status === 404) {
                    alert("404 Not Found");
                    /* 对404的处理 */
                    return;
                }
                else if (xmlHttp.status == 403) {
                    alert("403 Forbidden");
                    /* 对403的处理  */
                    return;
                }
                else {
                    alert(xmlHttp.status);
                    /* 对出现了其他错误代码所示错误的处理   */
                    return;
                }
            }

        };

        //把请求发送到服务器上的指定文件（url指向的文件）进行处理
        xmlHttp.open("GET", url, true);        //true表示异步处理
        xmlHttp.send();
    }
</script>

</body>
</html>
