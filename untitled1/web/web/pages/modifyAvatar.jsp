<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/28
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Title</title>
    <!-- 告诉浏览器屏幕自适应 -->
    <meta dName="viewport" content="width=device-width, initial-scale=1">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- 主题样式 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/adminlte/dist/css/adminlte.min.css">
    <!-- 离线 Google 字体: Source Sans Pro -->
    <link href="${pageContext.request.contextPath}/static/adminlte/dist/css/google.css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
    <!-- layui -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/modules/layer/default/layer.css">
</head>
<body>
<form id="form1" role="form" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
<%--<form role="form" enctype="multipart/form-data">--%>
    <div class="card-body">
        <div class="form-group">
            <div class="input-group" style="text-align: center; padding-bottom: 20px">
                <img id="user_avatar" src="${pageContext.request.contextPath}${sessionScope.loginUser.imgUrl}" class="img-circle elevation-2" style="margin: auto" width="200px" height="200px">
            </div>
            <div class="input-group">
                <%--<div class="custom-file">--%>
                    <%--<input type="file" class="custom-file-input" id="inputFile">--%>
                    <%--<label class="custom-file-label" for="inputFile">选择文件</label>--%>
                <%--</div>--%>
                <div class="custom-file">
                    <input type="file" id="inputFile" name="avatar">
                </div>
            </div>
            <span style="display: none" id="username">${sessionScope.loginUser.username}</span>
            <%--<span stype="hidden" id="avatar">${sessionScope.loginUser.imgUrl}</span>--%>
        </div>
        <div>
            <button type="submit" class="btn btn-primary container-fluid" id="modify_avatar">修改</button>
        </div>
    </div>
</form>
</body>
</html>

<!-- jQuery -->
<%--<script src="${pageContext.request.contextPath}/static/adminlte/plugins/jquery/jquery.min.js"></script>--%>
<script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE -->
<script src="${pageContext.request.contextPath}/static/adminlte/dist/js/adminlte.js"></script>

<!-- OPTIONAL SCRIPTS -->
<script src="${pageContext.request.contextPath}/static/adminlte/plugins/chart.js/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlte/dist/js/demo.js"></script>
<script src="${pageContext.request.contextPath}/static/adminlte/dist/js/pages/dashboard3.js"></script>
<script src="${pageContext.request.contextPath}/static/layui/lay/modules/layer.js"></script>

<script>
    $("#modify_avatar").click(function () {
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "text",//预期服务器返回的数据类型
            url: "../upload" ,//url
            data: $('#form1').serialize(),
            success: function (rtnText) {
                if(rtnText === "ok"){
                    layer.close("modifyAvatarLayer");
                }
            },
            error : function() {
                layer.msg("修改失败");
            }
        });
        return false;
    });
</script>