<%@ page import="com.filesharesystem.models.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Nikoace
  Date: 2018/5/22
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    User user = (User) request.getSession().getAttribute("user");
    String uid = null;
    if (user == null){
        System.out.println ( "no session" );
    }else{
        uid = user.getUid ();
    }

%>
<html>
<head>
    <title></title>
    <meta http-equiv="content-type" content="text/html" charset="utf-8">
    <script>
        var uid = $('#userId').val();
        alert(uid);
    </script>
</head>
<body>
<div class="content">
    <input id="userId" type="hidden" value="<%=uid%>">
    <form action="<%=request.getContextPath()%>/file/CommitFile.action" method="post">
        <input type="hidden" name="session" value="">
        <input type="hidden" name="status" value="1">
        <input type="hidden" name="type" value="1">
        <div class="form-group">
            <label>上传文件</label>
            <br/>
            <input type="file" name="filePath" >
        </div>
        <div class="form-group">
            <label>文件名</label>
            <input class="form-control" type="text" name="fileName" placeholder="insert fileName">
        </div>
        <div class="form-group">
            <label>文件类型</label>
            <select class="form-control" name="filetype">
                <option value="music">music</option>
                <option value="doc">document</option>
            </select>
            <button type="submit" class="btn mt-2 btn-outline-dark">提交</button>
        </div>
    </form>
</div>
</body>
</html>


