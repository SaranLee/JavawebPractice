<%@ page import="scu.demo.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/25
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>aside</title>
</head>
<body>
    <!-- 导航栏 -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- 左侧导航栏链接 -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="../../index3.html" class="nav-link">首页</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">联系</a>
            </li>
        </ul>

        <!-- 搜索表单 -->
        <form class="form-inline ml-3">
            <div class="input-group input-group-sm">
                <input class="form-control form-control-navbar" type="search" placeholder="搜索" aria-label="Search">
                <div class="input-group-append">
                    <button class="btn btn-navbar" type="submit">
                        <i class="fas fa-search"></i>
                    </button>
                </div>
            </div>
        </form>

        <!-- 右侧导航栏链接 -->
        <ul class="navbar-nav ml-auto">
            <!-- 消息下拉菜单 -->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-comments"></i>
                    <span class="badge badge-danger navbar-badge">3</span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <a href="#" class="dropdown-item">
                        <!-- 消息开始 -->
                        <div class="media">
                            <img src="${pageContext.request.contextPath}/static/adminlte/dist/img/user1-128x128.jpg" alt="用户头像" class="img-size-50 mr-3 img-circle">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Brad Diesel
                                    <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">有空的话就打电话给我...</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 小时前</p>
                            </div>
                        </div>
                        <!-- 消息结束 -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <!-- 消息开始 -->
                        <div class="media">
                            <img src="${pageContext.request.contextPath}/static/adminlte/dist/img/user8-128x128.jpg" alt="用户头像" class="img-size-50 img-circle mr-3">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    John Pierce
                                    <span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">我收到你的消息了</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 小时前</p>
                            </div>
                        </div>
                        <!-- 消息结束 -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <!-- 消息开始 -->
                        <div class="media">
                            <img src="${pageContext.request.contextPath}/static/adminlte/dist/img/user3-128x128.jpg" alt="用户头像" class="img-size-50 img-circle mr-3">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Nora Silvester
                                    <span class="float-right text-sm text-warning"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">主题在这里</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 小时前</p>
                            </div>
                        </div>
                        <!-- 消息结束 -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item dropdown-footer">查看所有消息</a>
                </div>
            </li>
            <!-- 通知下拉菜单 -->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-bell"></i>
                    <span class="badge badge-warning navbar-badge">15</span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <span class="dropdown-item dropdown-header">15 条通知</span>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-envelope mr-2"></i> 4 条新消息
                        <span class="float-right text-muted text-sm">3 分钟前</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-users mr-2"></i> 8 个好友请求
                        <span class="float-right text-muted text-sm">12 小时前</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-file mr-2"></i> 3 个新报告
                        <span class="float-right text-muted text-sm">2 天前</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item dropdown-footer">查看所有通知</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
                    <i class="fas fa-th-large"></i>
                </a>
            </li>
        </ul>
    </nav>
    <!-- /.navbar -->

    <!-- 主侧边栏容器 -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- 品牌 Logo -->
        <a href="index3.html" class="brand-link">
            <img src="${pageContext.request.contextPath}/static/adminlte/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
            <span class="brand-text font-weight-light">AdminLTE 3</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- 侧边栏用户面板（可选） -->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img id="login_user_avatar" src="${pageContext.request.contextPath}${sessionScope.loginUser.imgUrl}" class="img-circle elevation-2" alt="用户头像">
                </div>
                <div class="info">
                    <a href="#" class="d-block">${sessionScope.loginUser.username}</a>
                </div>
            </div>

            <!-- 侧边栏菜单 -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                    <!-- 使用 .nav-icon 类添加图标，
                         或使用 font-awesome 或其他任何图标字体库 -->
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link link-1st">
                            <i class="nav-icon fas fa-edit"></i>
                            <p>
                                用户管理
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/viewpage?pageName=addUser.jsp" class="nav-link link-2nd">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>添加用户</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/user?method=list" class="nav-link link-2nd">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>用户列表</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                    <!-- 使用 .nav-icon 类添加图标，
                         或使用 font-awesome 或其他任何图标字体库 -->
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link link-1st">
                            <i class="nav-icon fas fa-edit"></i>
                            <p>
                                员工管理
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/emp?method=list" class="nav-link link-2nd">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>员工列表</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link link-2nd">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>添加员工</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>
</body>
</html>
