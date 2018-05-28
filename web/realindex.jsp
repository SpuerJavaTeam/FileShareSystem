<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
          type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/theme.css" type="text/css">
</head>

<body>
<%@include file="static/jsp/header.jsp" %>
<div class="p-0">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h3 class="py py-2">共享文件列表</h3>
            </div>
        </div>
    </div>
</div>
<div class="">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <p class="">共享文件数：<s:property value="count"/></p>
            </div>
        </div>
    </div>
</div>
<div class="p-0">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <table class="table" id="filetable">
                    <thead>
                    <tr>
                        <th>文件名</th>
                        <th>上传时间</th>
                        <th>上传用户</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="list">
                        <tr>
                            <td>
                                <s:property value="fileName"/>
                            </td>
                            <td>
                                <s:property value="created_at"/>
                            </td>
                            <td>
                                <s:property value="uid.username"/>
                            </td>
                            <td>
                                <a href="<s:property value="path"/>"><i class="fa d-inline fa-download"></i> </a>
                            </td>
                        </tr>
                    </s:iterator>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="py-1">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <ul class="pagination">
                    <li class="page-item">
                        <a class="page-link" href="#">
                            <span>«</span>
                            <span class="sr-only">Previous</span>
                        </a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="./user/index.jsp">1</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">2</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">3</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">4</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">
                            <span>»</span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<%@include file="static/jsp/tail.jsp" %>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>

</html>