
<%--
  Created by IntelliJ IDEA.
  User: Nikoace
  Date: 2018/5/22
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>

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
            <label>updateFile</label>
            <br/>
            <input type="file" name="filePath" >
        </div>
        <div class="form-group">
            <label>fileName</label>
            <input class="form-control" type="text" name="fileName" placeholder="insert fileName">
        </div>
        <div class="form-group">
            <label>fileType</label>
            <select class="form-control" name="filetype">
                <option value="music">music</option>
                <option value="doc">document</option>
            </select>
            <button type="submit" class="btn mt-2 btn-outline-dark">submit</button>
        </div>
    </form>
</div>
</body>
</html>


