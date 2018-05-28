
<%--
  Created by IntelliJ IDEA.
  User: Nikoace
  Date: 2018/5/22
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
    <meta http-equiv="content-type" content="text/html" charset="utf-8">
</head>
<body>
<div class="content">
    <form action="" method="post">
        <input type="hidden" name="session" value="">
        <input type="hidden" name="status" value="1">
        <input type="hidden" name="type" value="1">
        <div class="form-group">
            <label>oldfilename</label>
            <br/>
            <input class="form-control" type="text" name="oldfilename" placeholder="insert old filename" >
        </div>
        <div class="form-group">
            <label>filename</label>
            <br/>
            <input class="form-control" type="text" name="filename" placeholder="insert new filename" >
        </div>
        <div class="form-group">
            <label>changeFileType</label>
            <select class="form-control" name="filetype">
                <option value="music">music</option>
                <option value="doc">document</option>
            </select>
            <button type="submit" class="btn mt-2 btn-outline-dark">submit</button>
    </form>
</div>
</body>
</html>


