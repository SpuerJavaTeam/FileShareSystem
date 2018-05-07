<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>static/css/theme.css" type="text/css">
</head>

<body>
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
        <a class="btn navbar-btn ml-2 btn-light text-success" href="login.jsp">&nbsp;登录</a>
        <a class="btn navbar-btn ml-2 btn-light text-success" href="register.jsp">&nbsp;注册</a>
      </div>
    </div>
  </nav>
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
          <p class="">共享文件数：67 贡献者：6</p>
        </div>
      </div>
    </div>
  </div>
  <div class="p-0">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <table class="table">
            <thead>
              <tr>
                <th>文件名</th>
                <th>上传时间</th>
                <th>上传用户</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>共享系统.pdf</td>
                <td>2018-05-01 10:21:02</td>
                <td>Otto</td>
                <td>
                  <a href="#">下载</a>
                </td>
              </tr>
              <tr>
                <td>共享系统.pdf</td>
                <td>2018-05-01 10:21:03</td>
                <td>Thornton</td>
                <td>
                  <a href="#">下载</a>
                </td>
              </tr>
              <tr>
                <td>共享系统.pdf</td>
                <td>2018-05-01 10:21:03</td>
                <td>the Bird</td>
                <td>
                  <a href="#">下载</a>
                </td>
              </tr>
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
              <a class="page-link" href="#">1</a>
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
  <div class="bg-dark text-white py-2">
    <div class="container">
      <div class="row">
        <div class="col-md-12 mt-3 text-center">
          <p>© Copyright 2018 SuperJavaTeam - All rights reserved.</p>
        </div>
      </div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

</html>