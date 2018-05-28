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
    if (userIndex != null) {
        session.setAttribute ( "user", userIndex );
    } else {
%>
<script>
    alert("未登录");
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
            <ul class="list-group" id="myTab">
                <li class="list-group-item"><a href="#upfile">上传文件</a></li>
                <li class="list-group-item"><a href="#updatefile">修改文件</a></li>
                <li class="list-group-item"><a href="#updateuser">修改用户</a></li>
                <li class="list-group-item"><a href="<%session.invalidate();%>">退出登录</a></li>
            </ul>
        </div>

        <div class="col-lg-7">
            <div id="content">
                <div class="tab-content">
                    <div class="tab-pane active" id="upfile">
                        <div class="content">
                            <form action="<%=request.getContextPath()%>/file/CommitFile.action" method="post">
                                <input type="hidden" name="session" value="">
                                <input type="hidden" name="status" value="1">
                                <input type="hidden" name="type" value="1">
                                <div class="form-group">
                                    <label>上传文件</label>
                                    <br/>
                                    <input type="file" name="filePath">
                                </div>
                                <div class="form-group">
                                    <label>文件名</label>
                                    <input class="form-control" type="text" name="fileName"
                                           placeholder="insert fileName">
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
                    </div>
                    <div class="tab-pane" id="updatefile">
                        <div class="content">
                            <form action="" method="post">
                                <input type="hidden" name="session" value="">
                                <input type="hidden" name="status" value="1">
                                <input type="hidden" name="type" value="1">
                                <div class="form-group">
                                    <label>oldfilename</label>
                                    <br/>
                                    <input class="form-control" type="text" name="oldfilename"
                                           placeholder="insert old filename">
                                </div>
                                <div class="form-group">
                                    <label>filename</label>
                                    <br/>
                                    <input class="form-control" type="text" name="filename"
                                           placeholder="insert new filename">
                                </div>
                                <div class="form-group">
                                    <label>changeFileType</label>
                                    <select class="form-control" name="filetype">
                                        <option value="music">music</option>
                                        <option value="doc">document</option>
                                    </select>
                                    <button type="submit" class="btn mt-2 btn-outline-dark">submit</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="tab-pane" id="updateuser">
                        <div class="content">
                            <form action="" method="post">
                                <input type="hidden" name="session" value="">
                                <input type="hidden" name="status" value="1">
                                <input type="hidden" name="type" value="1">
                                <div class="form-group">
                                    <label>username</label>
                                    <br/>
                                    <input class="form-control" type="text" name="username"
                                           placeholder="insert new filename">
                                </div>
                                <div class="form-group">
                                    <label>filename</label>
                                    <br/>
                                    <input class="form-control" type="text" name="password"
                                           placeholder="输入新的用户名">
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn mt-2 btn-outline-dark">submit</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
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
    $(function () {
        $('#myTab a:last').tab('show');
    })
    $('#myTab a').click(function (e) {
        e.preventDefault;
        $(this).tab('show');
    })
</script>
</body>
</html>
